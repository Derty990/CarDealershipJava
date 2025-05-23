package org.project.business.dao;

import org.project.infrastructure.database.entity.CustomerEntity;

import java.util.Optional;

public interface CustomerDAO {
    Optional<CustomerEntity> findByEmail(String email);

    void issueInvoice(CustomerEntity customer);

    void saveServiceRequest(CustomerEntity customer);

    CustomerEntity saveCustomer(CustomerEntity entity);

}
