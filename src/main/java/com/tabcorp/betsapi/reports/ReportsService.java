package com.tabcorp.betsapi.reports;

import com.tabcorp.betsapi.bets.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportsService {

    private ReportsRepository repository;

    @Autowired
    public ReportsService(ReportsRepository repository) {
        this.repository = repository;
    }

    public List<Bet> getAllBets() {
        return new ArrayList<>(repository.findAll());
    }

    double investmentPerBetType(String betType) {
        List<Bet> betTypes = repository.findBetsByBetType(betType.toUpperCase());
        return betTypes.stream().mapToDouble(Bet::getAmount).sum();
    }

    double investmentPerCustomerId(Long customerId) {
        List<Bet> customerIdBets = repository.findBetsByCustomerId(customerId);
        return customerIdBets.stream().mapToDouble(Bet::getAmount).sum();
    }

    int betsSoldPerBetType(String betType) {
        return repository.findBetsByBetType(betType.toUpperCase()).size();
    }


}
