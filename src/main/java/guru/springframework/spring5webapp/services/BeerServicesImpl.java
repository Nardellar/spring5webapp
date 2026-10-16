package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
//functions and business logic relative to beers
@Slf4j
@Service
public class BeerServicesImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Galaxy").beerStyle("rosa").build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
       return BeerDto.builder()
               .id(UUID.randomUUID()).
               beerName("IPA").
               beerStyle("Bionda").
               upc((long) 15).
               build();
    }


    @Override
    public void updateBeer(UUID beeId, BeerDto beerDto) {
        //todo: real impl of update
    }


    @Override
    public void deleteById(UUID beerID) {
        log.debug("Deleting beer with id {}...", beerID);
    }


}
