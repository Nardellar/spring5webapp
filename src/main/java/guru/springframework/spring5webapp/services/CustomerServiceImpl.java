package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
   
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().
                id(UUID.randomUUID()).
                name("mariio").
                build();
    }

    /**
     * @param customerDto 
     */
    @Override
    public void updateCustomer(CustomerDto customerDto) {
            //todo: real impl
    }

    /**
     * @param customerId 
     */
    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deleting customer with id {}...", customerId);
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID()).name("puck").build();
    }
}
