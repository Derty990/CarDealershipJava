package org.project.business.dao;

import org.project.infrastructure.database.entity.SalesmanEntity;

import java.util.Optional;

public interface SalesmanDAO {

    Optional<SalesmanEntity> findByPesel(String pesel);
}
