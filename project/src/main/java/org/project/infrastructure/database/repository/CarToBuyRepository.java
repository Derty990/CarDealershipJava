package org.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.project.business.dao.CarToBuyDAO;
import org.project.domain.CarToBuy;
import org.project.infrastructure.database.repository.jpa.CarToBuyJpaRepository;
import org.project.infrastructure.database.repository.mapper.CarToBuyEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CarToBuyRepository implements CarToBuyDAO {

    private final CarToBuyJpaRepository carToBuyJpaRepository;
    private final CarToBuyEntityMapper carToBuyEntityMapper;

    @Override
    public Optional<CarToBuy> findCarToBuyByVin(String vin) {
        return carToBuyJpaRepository.findByVin(vin)
                .map(carToBuyEntityMapper::mapFromEntity);
    }
}

