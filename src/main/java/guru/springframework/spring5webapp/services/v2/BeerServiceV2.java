package guru.springframework.spring5webapp.services.v2;

import guru.springframework.spring5webapp.web.model.BeerDto;
import guru.springframework.spring5webapp.web.model.V2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerIdentifier);

    void updateBeer(UUID beeId, BeerDtoV2 beerDto);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);


    void deleteById(UUID beerID);
}



