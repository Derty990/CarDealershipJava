package org.project.business;

import lombok.AllArgsConstructor;
import org.project.business.dao.CustomerDAO;
import org.project.infrastructure.database.entity.CustomerEntity;
import org.project.infrastructure.database.entity.SalesmanEntity;

import java.util.Optional;

@AllArgsConstructor
public class CustomerService {

    private final CustomerDAO customerDAO;

    public void issueInvoice(CustomerEntity customer) {

        customerDAO.issueInvoice(customer);

    }

    public CustomerEntity findCustomer(String email) {

        Optional<CustomerEntity> customer = customerDAO.findByEmail(email);
        if (customer.isEmpty()) {
            throw new RuntimeException("Could not find customer by email: [%s]".formatted(email));
        }
        return customer.get();

    }
}
