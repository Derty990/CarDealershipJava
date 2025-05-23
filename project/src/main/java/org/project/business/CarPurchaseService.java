package org.project.business;

import lombok.AllArgsConstructor;
import org.project.business.management.FileDataPreparationService;
import org.project.business.management.Keys;
import org.project.infrastructure.database.entity.CarToBuyEntity;
import org.project.infrastructure.database.entity.CustomerEntity;
import org.project.infrastructure.database.entity.InvoiceEntity;
import org.project.infrastructure.database.entity.SalesmanEntity;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
public class CarPurchaseService {

    private final FileDataPreparationService fileDataPreparationService;
    private final CustomerService customerService;
    private final CarService carService;
    private final SalesmanService salesmanService;

    public void purchase() {
        var firstTimeData = fileDataPreparationService.prepareFirstTimePurchaseData();
        var nextTimeData = fileDataPreparationService.prepareNextTimePurchaseData();

        List<CustomerEntity> firstTimeCustomers = firstTimeData.stream()
                .map(this::createFirstTimeToBuyCustomer)
                .toList();

        firstTimeCustomers.forEach(customerService::issueInvoice);


        List<CustomerEntity> nextTimeCustomers = nextTimeData.stream()
                .map(this::createNextTimeToBuyCustomer)
                .toList();

        nextTimeCustomers.forEach(customerService::issueInvoice);

    }

    private CustomerEntity createFirstTimeToBuyCustomer(Map<String, List<String>> inputData) {

        CarToBuyEntity car = carService.findCarToBuy(inputData.get(Keys.Entity.CAR.toString()).get(0));
        SalesmanEntity salesman = salesmanService.findSalesman(inputData.get(Keys.Entity.SALESMAN.toString()).get(0));
        InvoiceEntity invoice = buildInvoice(car, salesman);

        return FileDataPreparationService.buildCustomerEntity(inputData.get(Keys.Entity.CUSTOMER.toString()), invoice);

    }

    private CustomerEntity createNextTimeToBuyCustomer(Map<String, List<String>> inputData) {

        CustomerEntity existingCustomer = customerService.findCustomer(inputData.get(Keys.Entity.CUSTOMER.toString()).get(0));
        CarToBuyEntity car = carService.findCarToBuy(inputData.get(Keys.Entity.CAR.toString()).get(0));
        SalesmanEntity salesman = salesmanService.findSalesman(inputData.get(Keys.Entity.SALESMAN.toString()).get(0));
        InvoiceEntity invoice = buildInvoice(car, salesman);
        existingCustomer.getInvoices().add(invoice);

        return existingCustomer;

    }

    private InvoiceEntity buildInvoice(CarToBuyEntity car, SalesmanEntity salesman) {
        return InvoiceEntity.builder()
                .invoiceNumber(UUID.randomUUID().toString())
                .dateTime(OffsetDateTime.now())
                .salesman(salesman)
                .car(car)
                .build();
    }

}
