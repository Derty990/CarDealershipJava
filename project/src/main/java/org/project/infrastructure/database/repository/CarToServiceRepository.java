package org.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.project.business.dao.CarToServiceDAO;
import org.project.domain.CarHistory;
import org.project.domain.CarToService;
import org.project.infrastructure.database.entity.CarToServiceEntity;
import org.project.infrastructure.database.repository.jpa.CarToServiceJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CarToServiceRepository implements CarToServiceDAO {

    private final CarToServiceJpaRepository carToServiceJpaRepository;
    private final CarToServiceMapper carToServiceMapper;

    @Override
    public Optional<CarToService> findCarToServiceByVin(String vin) {
        return carToServiceJpaRepository.findByVin(vin)
                .map(carToServiceMapper::mapFromEntity);
    }

    @Override
    public CarToService saveCarToService(CarToService entity) {
        CarToServiceEntity toSave = carToServiceMapper.mapToEntity(entity);
        CarToServiceEntity saved = carToServiceJpaRepository.save(toSave);
        return carToServiceMapper.mapFromEntity(saved);
    }

    @Override
    public CarHistory findCarHistoryByVin(String vin) {
        CarToServiceEntity carHistoryByVin = carToServiceJpaRepository.findCarHistoryByVin(vin);
        return carToServiceMapper.mapFromEntity(vin, carHistoryByVin);
    }
}
