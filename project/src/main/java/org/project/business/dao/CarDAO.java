package org.project.business.dao;

import org.project.domain.CarHistory;
import org.project.domain.CarToBuy;
import org.project.domain.CarToService;

import java.util.Optional;

public interface CarDAO {

    Optional<CarToBuy> findCarToBuyByVin(String vin);

    Optional<CarToService> findCarToServiceByVin(String vin);

    CarToService saveCarToService(CarToService entity);

    CarHistory findCarHistoryByVin(String vin);
}
