package guru.springframework.spring5webapp.domain;

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
public class Customer {

    private UUID id;

    private String name;
}
