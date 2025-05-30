package org.project.business.dao;

import org.project.domain.CarHistory;
import org.project.domain.CarToService;

import java.util.Optional;

public interface CarToServiceDAO {
    Optional<CarToService> findCarToServiceByVin(String vin);

    CarToService saveCarToService(CarToService entity);

    CarHistory findCarHistoryByVin(String vin);
}
