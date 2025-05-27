package org.project.infrastructure.database.repository.jpa;


import org.project.infrastructure.database.entity.ServiceMechanicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceMechanicJpaRepository extends JpaRepository<ServiceMechanicEntity, Integer> {


}
