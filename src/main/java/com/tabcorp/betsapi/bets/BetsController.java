package com.tabcorp.betsapi.bets;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class BetsController {

    private BetsService service;

    @Autowired
    public BetsController(BetsService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String welcome(){
        return "Welcome to TabCorp";
        }

    @PostMapping(value = "/bets")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBets(@Valid @RequestBody Bet newBet){
        if(Validations.isBetValid(newBet)){
            service.save(newBet);
        }
    }


}
