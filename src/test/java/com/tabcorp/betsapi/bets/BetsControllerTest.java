package com.tabcorp.betsapi.bets;

import com.tabcorp.betsapi.AbstractTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class BetsControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

/*    @Test
    public void createBets() throws Exception {
        String uri = "/bets";
        Bet bet = new Bet(1L, LocalDateTime.now(), "WIN", 20L, 100.50);

        String inputJson = super.mapToJson(bet);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }*/
}