package org.project.business.dao;

import org.project.domain.Salesman;

import java.util.Optional;

public interface SalesmanDAO {

    Optional<Salesman> findByPesel(String pesel);
}
