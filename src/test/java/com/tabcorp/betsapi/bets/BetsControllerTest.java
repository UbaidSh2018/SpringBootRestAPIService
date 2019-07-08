package com.tabcorp.betsapi.bets;

import com.tabcorp.betsapi.BetsApiApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BetsApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BetsControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }


    @Test
    public void createBets() throws Exception {

        Bet bet = new Bet();
        bet.setCustomerId(1L);
        bet.setDateTime(LocalDateTime.now());
        bet.setBetType("WIN");
        bet.setPropNumber(20L);
        bet.setAmount(100.50);

        ResponseEntity<Bet> postResponse = restTemplate.postForEntity(getRootUrl() + "/bets", bet, Bet.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }


}