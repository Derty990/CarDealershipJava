package org.project.infrastructure.database.repository.jpa;

import org.project.infrastructure.database.entity.MechanicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MechanicJpaRepository extends JpaRepository<MechanicEntity, Integer> {


}
