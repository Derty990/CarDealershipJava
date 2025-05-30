package org.project.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.project.business.dao.SalesmanDAO;
import org.project.domain.Salesman;
import org.project.infrastructure.database.repository.jpa.SalesmanJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class SalesmanRepository implements SalesmanDAO {

    private final SalesmanJpaRepository salesmanJpaRepository;
    private final SalesmanMapper salesmanMapper;


    @Override
    public Optional<Salesman> findByPesel(String pesel) {
        return salesmanJpaRepository.findByPesel(pesel)
                .map(salesmanMapper::mapFromEntity);

    }


}
