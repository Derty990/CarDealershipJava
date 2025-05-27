package org.project.infrastructure.database.repository.jpa;

import org.project.infrastructure.database.entity.CarToBuyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarToBuyJpaRepository extends JpaRepository<CarToBuyEntity, Integer> {


}
