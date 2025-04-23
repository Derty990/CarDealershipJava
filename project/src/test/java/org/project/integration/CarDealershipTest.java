package org.project.integration;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.project.business.CarPurchaseService;
import org.project.business.CarService;
import org.project.business.CustomerService;
import org.project.business.SalesmanService;
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

    @BeforeEach
    void beforeEach() {
        CarDAO carDAO = new CarRepository();
        SalesmanDAO salesmanDAO = new SalesmanRepository();
        CustomerDAO customerDAO = new CustomerRepository();
        FileDataPreparationService fileDataPreparationService = new FileDataPreparationService();
        this.carDealershipManagementService = new CarDealershipManagementService(
                new CarDealershipManagementRepository(),
                fileDataPreparationService
        );

        this.carPurchaseService = new CarPurchaseService(
                fileDataPreparationService,
                new CustomerService(customerDAO),
                new CarService(carDAO),
                new SalesmanService(salesmanDAO)
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
