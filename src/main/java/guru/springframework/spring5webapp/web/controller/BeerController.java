package guru.springframework.spring5webapp.web.controller;

import guru.springframework.spring5webapp.services.BeerService;
import guru.springframework.spring5webapp.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@RequestMapping("/api/v1/beer")
@RestController
//gets request and activates right function to then send repsonses
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerIdentifier){

        return new ResponseEntity<>(beerService.getBeerById(beerIdentifier), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createBeer(@Valid @RequestBody BeerDto beerDto) {
        BeerDto savedDto= beerService.saveNewBeer(beerDto);

        //fornire ID prodtto generato al client cosi da
        // aggiornarlo sullo stato reale del prodotto
        //l'info la si mette nell'header nel campo "Location" http
        HttpHeaders headers = new HttpHeaders();
        //todo: add hostname url
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Void> updateBeer(@PathVariable UUID beerId,@RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerID){

        beerService.deleteById(beerID);

    }


}
