package org.project.infrastructure.database.repository.jpa;

import org.project.infrastructure.database.entity.SalesmanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesmanJpaRepository extends JpaRepository<SalesmanEntity, Integer> {


    Optional<SalesmanEntity> findByPesel(String pesel);

}
