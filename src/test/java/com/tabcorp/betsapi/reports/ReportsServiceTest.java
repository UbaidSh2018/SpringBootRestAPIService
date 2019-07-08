package com.tabcorp.betsapi.reports;

import com.tabcorp.betsapi.bets.Bet;
import com.tabcorp.betsapi.reports.ReportsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReportsServiceTest {


    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ReportsRepository repository;

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
    public void findBetsByBetsType_should_return_list_of_same_betTypes() {
        List<Bet> bets = repository.findBetsByBetType("WIN");
        assertFalse(bets.isEmpty());
        assertEquals(1, bets.size());

        String expectedBetType = bets.get(0).getBetType();
        long expectedCustomerId = bets.get(0).getCustomerId();

        assertEquals("WIN", expectedBetType);
        assertEquals(1L, expectedCustomerId);

    }

    @Test
    public void findBetsByCustomerId_should_return_list_of_bets_with_same_customer_id() {
        List<Bet> bets = repository.findBetsByCustomerId(2L);
        assertFalse(bets.isEmpty());
        assertEquals(1, bets.size());

        long expectedCustomerId = bets.get(0).getCustomerId();
        String expectedBetType = bets.get(0).getBetType();

        assertEquals(2L, expectedCustomerId);
        assertEquals("PLACE", expectedBetType);
    }

}
