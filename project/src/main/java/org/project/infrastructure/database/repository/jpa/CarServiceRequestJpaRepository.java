package org.project.infrastructure.database.repository.jpa;

import org.project.infrastructure.database.entity.CarServiceRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarServiceRequestJpaRepository extends JpaRepository<CarServiceRequestEntity, Integer> {


}
