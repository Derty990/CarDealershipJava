package org.project.infrastructure.database.repository.jpa;

import org.project.infrastructure.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Integer> {


    Optional<CustomerEntity> findByEmail(String email);

}

