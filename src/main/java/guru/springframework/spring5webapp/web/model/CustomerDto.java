package guru.springframework.spring5webapp.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.UUID;


@Data //genera getter e setter di tutti i campi e tostring
@NoArgsConstructor //serve al controller per creare oggetto e poi rimepirlo
@AllArgsConstructor
@Builder
public class CustomerDto {

    private UUID id;
    @NotNull @Length(min = 3, max = 100, message = "Il nome della birra deve essere compreso tra 3 e 50 caratteri")
    private String name;
}
