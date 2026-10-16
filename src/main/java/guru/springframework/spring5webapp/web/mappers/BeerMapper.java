package guru.springframework.spring5webapp.web.mappers;

import guru.springframework.spring5webapp.domain.Beer;
import guru.springframework.spring5webapp.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

}
