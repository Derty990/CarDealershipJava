package org.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.project.business.dao.CustomerDAO;
import org.project.domain.Customer;
import org.project.infrastructure.database.entity.CarServiceRequestEntity;
import org.project.infrastructure.database.entity.CustomerEntity;
import org.project.infrastructure.database.entity.InvoiceEntity;
import org.project.infrastructure.database.repository.jpa.CarServiceRequestJpaRepository;
import org.project.infrastructure.database.repository.jpa.CustomerJpaRepository;
import org.project.infrastructure.database.repository.jpa.InvoiceJpaRepository;
import org.project.infrastructure.database.repository.mapper.CarServiceRequestEntityMapper;
import org.project.infrastructure.database.repository.mapper.CustomerEntityMapper;
import org.project.infrastructure.database.repository.mapper.InvoiceEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CustomerRepository implements CustomerDAO {

    private final CustomerJpaRepository customerJpaRepository;
    private final InvoiceJpaRepository invoiceJpaRepository;
    private final CarServiceRequestJpaRepository carServiceRequestJpaRepository;

    private final CustomerEntityMapper customerEntityMapper;
    private final InvoiceEntityMapper invoiceEntityMapper;
    private final CarServiceRequestEntityMapper carServiceRequestEntityMapper;


    @Override
    public Optional<Customer> findByEmail(String email) {
        return customerJpaRepository.findByEmail(email)
                .map(customerEntityMapper::mapFromEntity);

    }

    @Override
    public void issueInvoice(Customer customer) {
        CustomerEntity customerToSave = customerEntityMapper.mapToEntity(customer);
        CustomerEntity customerSaved = customerJpaRepository.save(customerToSave);

        customer.getInvoices().stream()
                .map(invoiceEntityMapper::mapToEntity)
                .forEach((InvoiceEntity entity) -> {
                    entity.setCustomer(customerSaved);
                    invoiceJpaRepository.saveAndFlush(entity);
                });

    }

    @Override
    public void saveServiceRequest(Customer customer) {
        List<CarServiceRequestEntity> serviceRequests = customer.getCarServiceRequests().stream()
                .map(carServiceRequestEntityMapper::mapToEntity)
                .toList();

        serviceRequests
                .forEach(request -> request.setCustomer(customerEntityMapper.mapToEntity(customer)));
        carServiceRequestJpaRepository.saveAllAndFlush(serviceRequests);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerEntity toSave = customerEntityMapper.mapToEntity(customer);
        CustomerEntity saved = customerJpaRepository.save(toSave);
        return customerEntityMapper.mapFromEntity(saved);

    }
}
