package guru.springframework.spring5webapp.web.controller.v2;


import guru.springframework.spring5webapp.services.v2.BeerServiceV2;
import guru.springframework.spring5webapp.web.model.V2.BeerDtoV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor //costruttore con solo i parametri minimi necessari. quindi var final e campi @Notnull
@Validated //serve per validare i parametri semplici (non oggetti o strutture dati)
//@Valid. serve a validare gli oggetti compelssi, guarda i campi dell'oggetto e contorlla che rispetitno gli standard che abbiamo messo nell'entity

@RequestMapping("/api/v2/beer")
@RestController

public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    /*public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }*/

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable("beerId") UUID beerIdentifier){

        return new ResponseEntity<>(beerServiceV2.getBeerById(beerIdentifier), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createBeer(@Valid @NotNull @RequestBody BeerDtoV2 beerDto) {
        BeerDtoV2 savedDto= beerServiceV2.saveNewBeer(beerDto);

        //fornire ID prodtto generato al client cosi da
        // aggiornarlo sullo stato reale del prodotto
        //l'info la si mette nell'header nel campo "Location" http
        HttpHeaders headers = new HttpHeaders();
        //todo: add hostname url
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Void> updateBeer(@PathVariable UUID beerId,@Valid @RequestBody BeerDtoV2 beerDto) {
        beerServiceV2.updateBeer(beerId, beerDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerID){

        beerServiceV2.deleteById(beerID);

    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException cve){
//        List<String> errors = new ArrayList<>(cve.getConstraintViolations().size());
//        cve.getConstraintViolations().forEach(constraintViolation -> {
//            errors.add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
//        });
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }

}
