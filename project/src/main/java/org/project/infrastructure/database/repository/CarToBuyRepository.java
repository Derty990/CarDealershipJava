package org.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.project.business.dao.CarToBuyDAO;
import org.project.domain.CarServiceRequest;
import org.project.infrastructure.database.repository.jpa.CarToBuyJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@AllArgsConstructor
public class CarToBuyRepository implements CarToBuyDAO {

    private final CarToBuyJpaRepository carToBuyJpaRepository;
    private final CarToBuyMapper carToBuyMapper;

    @Override
    public Set<CarServiceRequest> findActiveServiceRequestsByCarVin(String vin) {
        return carToBuyJpaRepository.findByVin(vin)
                .map(carToBuyMapper::mapFromEntity);
    }
}

