package org.project.business.dao;

import org.project.infrastructure.database.entity.MechanicEntity;

import java.util.Optional;

public interface MechanicDAO {

    Optional<MechanicEntity> findByPesel(String pesel);
}
