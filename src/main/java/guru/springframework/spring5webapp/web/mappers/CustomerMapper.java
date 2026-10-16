package guru.springframework.spring5webapp.web.mappers;

import guru.springframework.spring5webapp.domain.Customer;
import guru.springframework.spring5webapp.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);
}


