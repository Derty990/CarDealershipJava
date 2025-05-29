package org.project.business;

import lombok.AllArgsConstructor;
import org.project.business.dao.SalesmanDAO;
import org.project.domain.Salesman;

import java.util.Optional;

@AllArgsConstructor
public class SalesmanService {

    private final SalesmanDAO salesmanDAO;

    public Salesman findSalesman(String pesel) {

        Optional<Salesman> salesman = salesmanDAO.findByPesel(pesel);
        if (salesman.isEmpty()) {
            throw new RuntimeException("Could not find salesman by pesel: [%s]".formatted(pesel));
        }
        return salesman.get();

    }

}
