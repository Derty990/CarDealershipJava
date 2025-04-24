package org.project.integration;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.project.business.*;
import org.project.business.dao.CarDAO;
import org.project.business.dao.CustomerDAO;
import org.project.business.dao.SalesmanDAO;
import org.project.business.management.CarDealershipManagementService;
import org.project.business.management.FileDataPreparationService;
import org.project.infrastructure.configuration.HibernateUtil;
import org.project.infrastructure.database.repository.CarDealershipManagementRepository;
import org.project.infrastructure.database.repository.CarRepository;
import org.project.infrastructure.database.repository.CustomerRepository;
import org.project.infrastructure.database.repository.SalesmanRepository;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarDealershipTest {

    private CarDealershipManagementService carDealershipManagementService;
    private CarPurchaseService carPurchaseService;
    private CarServiceRequestService carServiceRequestService;

    @BeforeEach
    void beforeEach() {
        CarDealershipManagementRepository carDealershipManagementService1 = new CarDealershipManagementRepository();
        CarDAO carDAO = new CarRepository();
        SalesmanDAO salesmanDAO = new SalesmanRepository();
        CustomerDAO customerDAO = new CustomerRepository();
        FileDataPreparationService fileDataPreparationService = new FileDataPreparationService();
        CarService carService = new CarService(carDAO);
        SalesmanService salesmanService = new SalesmanService(salesmanDAO);
        CustomerService customerService = new CustomerService(customerDAO);
        this.carDealershipManagementService = new CarDealershipManagementService(
                carDealershipManagementService1,
                fileDataPreparationService
        );

        this.carPurchaseService = new CarPurchaseService(
                fileDataPreparationService,
                customerService,
                carService,
                salesmanService
        );

        this.carServiceRequestService = new CarServiceRequestService(
                fileDataPreparationService,
                carService,
                customerService
        );


    }

    @AfterAll
    static void afterAll() {
        HibernateUtil.closeSessionFactory();
    }

    @Test
    @Order(1)
    void purge() {
        log.info("### RUNNING ORDER 1");
        carDealershipManagementService.purge();

    }

    @Test
    @Order(2)
    void init() {
        log.info("### RUNNING ORDER 2");
        carDealershipManagementService.init();
    }

    @Test
    @Order(3)
    void purchase() {
        log.info("### RUNNING ORDER 3");
        carPurchaseService.purchase();
    }

    @Test
    @Order(4)
    void makeServiceRequests() {
        log.info("### RUNNING ORDER 4");
        carServiceRequestService.requestService();

    }

    @Test
    @Order(5)
    void processServiceRequests() {
        log.info("### RUNNING ORDER 5");
    }

    @Test
    @Order(6)
    void printCarHistory() {
        log.info("### RUNNING ORDER 6");
    }


}
