package org.project.business;

import lombok.AllArgsConstructor;
import org.project.business.dao.CustomerDAO;
import org.project.domain.Address;
import org.project.domain.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    public void issueInvoice(Customer customer) {

        customerDAO.issueInvoice(customer);

    }

    @Transactional
    public Customer findCustomer(String email) {

        Optional<Customer> customer = customerDAO.findByEmail(email);
        if (customer.isEmpty()) {
            throw new RuntimeException("Could not find customer by email: [%s]".formatted(email));
        }
        return customer.get();

    }

    @Transactional
    public void saveServiceRequest(Customer customer) {

        customerDAO.saveServiceRequest(customer);

    }

    @Transactional
    public Customer saveCustomer(Customer customer) {

        return customerDAO.saveCustomer(customer);

    }
}
