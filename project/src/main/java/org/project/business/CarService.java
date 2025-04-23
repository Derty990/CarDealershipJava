package org.project.business;

import lombok.AllArgsConstructor;
import org.project.business.dao.CarDAO;
import org.project.infrastructure.database.entity.CarToBuyEntity;

import java.util.Optional;

@AllArgsConstructor
public class CarService {

    private final CarDAO carDAO;


    public CarToBuyEntity findCarToBuy(String vin) {

        Optional<CarToBuyEntity> carToBuyByVin = carDAO.findCarToBuyByVin(vin);
        if(carToBuyByVin.isEmpty()){
            throw new RuntimeException("Could not find car by vin: [%s]".formatted(vin));
        }
        return carToBuyByVin.get();

    }
}
