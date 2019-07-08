package com.tabcorp.betsapi.bets;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BetsServiceTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    BetsRepository betsRepository;

    @Before
    public void setUp() {
        Bet firstBet = new Bet();
        firstBet.setCustomerId(1L);
        firstBet.setDateTime(LocalDateTime.now());
        firstBet.setBetType("WIN");
        firstBet.setPropNumber(20L);
        firstBet.setAmount(100.50);
        entityManager.persist(firstBet);

        Bet secondBet = new Bet();
        secondBet.setCustomerId(2L);
        secondBet.setDateTime(LocalDateTime.now());
        secondBet.setBetType("PLACE");
        secondBet.setPropNumber(20L);
        secondBet.setAmount(100.50);
        entityManager.persist(secondBet);

    }


    @Test
    public void findAllBets_should_return_list_of_created_bits() {

        List<Bet> bets = betsRepository.findAll();
        assertFalse(bets.isEmpty());
        assertEquals(2, bets.size());

        long expectedCustomerId = bets.get(0).getCustomerId();
        String expectedBetType = bets.get(0).getBetType();
        assertEquals(1L, expectedCustomerId);
        assertEquals("WIN", expectedBetType);

        long expectedCustomerIdTwo = bets.get(1).getCustomerId();
        String expectedBetTypeTwo = bets.get(1).getBetType();
        assertEquals(2L, expectedCustomerIdTwo);
        assertEquals("PLACE", expectedBetTypeTwo);

    }

    @Test
    public void createBets_should_create_bet_object() {

        Bet bet = new Bet();
        bet.setCustomerId(1L);
        bet.setDateTime(LocalDateTime.now());
        bet.setBetType("WIN");
        bet.setPropNumber(20L);
        bet.setAmount(100.50);
        betsRepository.save(bet);

        assertNotNull(bet);

    }


}
