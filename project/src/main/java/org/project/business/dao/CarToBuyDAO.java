package org.project.business.dao;

import org.project.domain.CarToBuy;

import java.util.Optional;

public interface CarToBuyDAO {

    Optional<CarToBuy> findCarToBuyByVin(String vin);
}
