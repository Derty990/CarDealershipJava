package org.project.infrastructure.database.repository.jpa;

import org.project.infrastructure.database.entity.SalesmanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesmanJpaRepository extends JpaRepository<SalesmanEntity, Integer> {


}
