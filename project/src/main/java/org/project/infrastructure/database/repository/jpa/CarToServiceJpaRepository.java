package org.project.infrastructure.database.repository.jpa;


import org.project.infrastructure.database.entity.CarToServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarToServiceJpaRepository extends JpaRepository<CarToServiceEntity, Integer> {

}
