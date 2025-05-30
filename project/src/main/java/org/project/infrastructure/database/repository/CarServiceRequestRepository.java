package org.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.project.business.dao.CarServiceRequestDAO;
import org.project.domain.CarServiceRequest;
import org.project.infrastructure.database.repository.jpa.CarServiceRequestJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class CarServiceRequestRepository implements CarServiceRequestDAO {

    private final CarServiceRequestJpaRepository carServiceRequestJpaRepository;
    private final CarServiceRequestEntityMapper carServiceRequestEntityMapper;

    @Override
    public Set<CarServiceRequest> findActiveServiceRequestsByCarVin(String carVin) {
        return carServiceRequestJpaRepository.findActiveServiceRequestsByCarVin(carVin).stream()
                .map(obj -> carServiceRequestEntityMapper.mapFromEntity(obj))
                .collect(Collectors.toSet());

    }
}
