package com.tabcorp.betsapi.reports;

import com.tabcorp.betsapi.bets.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportsController{

    private ReportsService service;

    @Autowired
    public ReportsController(ReportsService reportService){
        this.service = reportService;
    }

    @GetMapping(value = "/bets")
    public List<Bet> getAllBets() {
        return service.getAllBets();
    }

    @GetMapping(value = "/reports/bettype/{betType}")
    public double investmentPerBetType(@PathVariable String betType) {
        return service.investmentPerBetType(betType);
    }

    @GetMapping(value = "/reports/customer/{customerId}")
    public double investmentPerCustomerId(@PathVariable Long customerId) {
        return service.investmentPerCustomerId(customerId);
    }

    @GetMapping(value = "/reports/sold/{betType}")
    public int betsSoldPerBetType(@PathVariable String betType) {
        return service.betsSoldPerBetType(betType);
    }

}

