package com.tabcorp.betsapi.config;

import com.tabcorp.betsapi.bets.Bet;
import com.tabcorp.betsapi.reports.ReportsRepository;
import com.tabcorp.betsapi.reports.ReportsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SpringSecurityIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReportsService mockService;

    @Before
    public void setUp() {
        Bet firstBet = new Bet(1L, LocalDateTime.now(), "WIN", 20L, 100.50);
        List<Bet> bets = new ArrayList<>();
        bets.add(firstBet);
        when(mockService.getAllBets()).thenReturn(bets);
    }

    @WithMockUser("USER")
    @Test
    public void test_spring_security_with_user_login() throws Exception {

        mockMvc.perform(get("/bets"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void test_spring_security_without_login_should_throw_401() throws Exception{
        mockMvc.perform(get("/bets"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}