package org.project.business.dao;

import org.project.infrastructure.database.entity.CarToBuyEntity;
import org.project.infrastructure.database.entity.CarToServiceEntity;

import java.util.Optional;

public interface CarDAO {

    Optional<CarToBuyEntity> findCarToBuyByVin(String vin);

    Optional<CarToServiceEntity> findCarToServiceByVin(String vin);

    CarToServiceEntity saveCarToService(CarToServiceEntity entity);

}
