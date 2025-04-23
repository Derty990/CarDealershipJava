package org.project.business.dao;

import org.project.infrastructure.database.entity.CarToBuyEntity;

import java.util.Optional;

public interface CarDAO {

    Optional<CarToBuyEntity> findCarToBuyByVin(String vin);

}
