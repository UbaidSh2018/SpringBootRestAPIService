package com.tabcorp.betsapi.bets;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ValidationsTest {

    private Bet firstBet;

    @Before
    public void setUp(){
        firstBet = new Bet();
        firstBet.setCustomerId(1L);
        firstBet.setDateTime(LocalDateTime.now());
        firstBet.setBetType("WIN");
        firstBet.setPropNumber(20L);
        firstBet.setAmount(1000.50);
    }

    @Test
    public void bet_meets_all_validations_should_return_true() {
       boolean result = Validations.isBetValid(firstBet);
        assertTrue(result);
    }

}