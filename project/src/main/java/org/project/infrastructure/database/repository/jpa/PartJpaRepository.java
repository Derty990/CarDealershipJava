package org.project.infrastructure.database.repository.jpa;


import org.project.infrastructure.database.entity.PartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartJpaRepository extends JpaRepository<PartEntity, Integer> {

    Optional<PartEntity> findBySerialNumber(String serialNumber);

}
