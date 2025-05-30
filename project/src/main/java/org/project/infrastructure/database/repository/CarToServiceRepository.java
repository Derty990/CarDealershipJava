package org.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.project.business.dao.CarToServiceDAO;
import org.project.domain.CarHistory;
import org.project.domain.CarToService;
import org.project.infrastructure.database.entity.CarToServiceEntity;
import org.project.infrastructure.database.repository.jpa.CarToServiceJpaRepository;
import org.project.infrastructure.database.repository.mapper.CarToServiceEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CarToServiceRepository implements CarToServiceDAO {

    private final CarToServiceJpaRepository carToServiceJpaRepository;
    private final CarToServiceEntityMapper carToServiceEntityMapper;

    @Override
    public Optional<CarToService> findCarToServiceByVin(String vin) {
        return carToServiceJpaRepository.findByVin(vin)
                .map(carToServiceEntityMapper::mapFromEntity);
    }

    @Override
    public CarToService saveCarToService(CarToService car) {
        CarToServiceEntity toSave = carToServiceEntityMapper.mapToEntity(car);
        CarToServiceEntity saved = carToServiceJpaRepository.save(toSave);
        return carToServiceEntityMapper.mapFromEntity(saved);
    }

    @Override
    public CarHistory findCarHistoryByVin(String vin) {
        CarToServiceEntity carHistoryByVin = carToServiceJpaRepository.findCarHistoryByVin(vin);
        return carToServiceEntityMapper.mapFromEntity(vin, carHistoryByVin);
    }
}
