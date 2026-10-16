package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    void updateCustomer(CustomerDto customerDto);

    void deleteCustomer(UUID customerId);

    CustomerDto getCustomerById(UUID customerId);
}
