package guru.springframework.spring5webapp.services.v2;

import guru.springframework.spring5webapp.web.model.BeerDto;
import guru.springframework.spring5webapp.web.model.V2.BeerDtoV2;
import guru.springframework.spring5webapp.web.model.V2.BeerSyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {

    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID()).beerName("Galaxy").beerStyle(BeerSyleEnum.STOUT).build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID()).
                beerName("IPA").
                beerStyle(BeerSyleEnum.IPA).
                upc(15L).
                build();
    }


    @Override
    public void updateBeer(UUID beeId, BeerDtoV2 beerDto) {
        //todo: real impl of update
    }


    @Override
    public void deleteById(UUID beerID) {
        log.debug("Deleting beer with id {}...", beerID);
    }
}
