package org.project.business.dao;

import org.project.domain.Service;

import java.util.Optional;

public interface ServiceDAO {
    Optional<Service> findByServiceCode(String serviceCode);

}
