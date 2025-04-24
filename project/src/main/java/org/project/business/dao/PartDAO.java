package org.project.business.dao;

import org.project.infrastructure.database.entity.PartEntity;

import java.util.Optional;

public interface PartDAO {
    Optional<PartEntity> findBySerialNumber(String serialNumber);
}
