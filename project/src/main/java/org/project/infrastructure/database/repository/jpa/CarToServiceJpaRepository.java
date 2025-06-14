package org.project.infrastructure.database.repository.jpa;


import org.project.infrastructure.database.entity.CarToServiceEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarToServiceJpaRepository extends JpaRepository<CarToServiceEntity, Integer> {

    Optional<CarToServiceEntity> findByVin(String vin);


    @EntityGraph(
            type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {
                    "carServiceRequests",
                    "carServiceRequests.serviceMechanics",
                    "carServiceRequests.serviceMechanics.service",
                    "carServiceRequests.serviceParts",
                    "carServiceRequests.serviceParts.part",
            }
    )
    CarToServiceEntity findCarHistoryByVin(String vin);
}
