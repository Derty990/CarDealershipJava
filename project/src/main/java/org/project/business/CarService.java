package org.project.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.business.dao.CarToBuyDAO;
import org.project.business.dao.CarToServiceDAO;
import org.project.domain.CarHistory;
import org.project.domain.CarToBuy;
import org.project.domain.CarToService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class CarService {
    private final CarToBuyDAO carToBuyDAO;

    private final CarToServiceDAO carToServiceDAO;

    @Transactional
    public List<CarToBuy> findAvailableCars() {
       List<CarToBuy> availableCars = carToBuyDAO.findAvailable();
       log.info("Available cars: [{}]", availableCars.size());
       return availableCars;

    }

    @Transactional
    public CarToBuy findCarToBuy(String vin) {

        Optional<CarToBuy> carToBuyByVin = carToBuyDAO.findCarToBuyByVin(vin);
        if (carToBuyByVin.isEmpty()) {
            throw new RuntimeException("Could not find car by vin: [%s]".formatted(vin));
        }
        return carToBuyByVin.get();

    }

    @Transactional
    public Optional<CarToService> findCarToService(String vin) {

        return carToServiceDAO.findCarToServiceByVin(vin);

    }

    @Transactional
    public CarToService saveCarToService(CarToBuy carToBuy) {

        CarToService carToService = CarToService.builder()
                .vin(carToBuy.getVin())
                .brand(carToBuy.getBrand())
                .model(carToBuy.getModel())
                .year(carToBuy.getYear())
                .build();
        return carToServiceDAO.saveCarToService(carToService);

    }

    @Transactional
    public CarToService saveCarToService(CarToService car) {

        return carToServiceDAO.saveCarToService(car);
    }

    public void printCarHistory(String vin) {

        CarHistory carHistoryByVin = carToServiceDAO.findCarHistoryByVin(vin);
        log.info("### CAR HISTORY FOR VIN: [{}]", vin);
        carHistoryByVin.getCarServiceRequests().forEach(this::printServiceRequest);


    }

    private void printServiceRequest(CarHistory.CarServiceRequest serviceRequest) {

        log.info("### SERVICE REQUEST: [{}]", serviceRequest);
        serviceRequest.getServices().forEach(service -> log.info("### SERVICE: [{}]", service));
        serviceRequest.getParts().forEach(part -> log.info("### PART: [{}]", part));

    }

}
