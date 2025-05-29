package org.project.business.dao;

import org.project.domain.Part;

import java.util.Optional;

public interface PartDAO {
    Optional<Part> findBySerialNumber(String serialNumber);
}
