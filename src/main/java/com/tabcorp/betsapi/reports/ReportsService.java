package com.tabcorp.betsapi.reports;

import com.tabcorp.betsapi.bets.Bet;
import com.tabcorp.betsapi.bets.BetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportsService {

    private ReportsRepository repository;

    @Autowired
    public ReportsService(ReportsRepository repository) {
        this.repository =  repository;
    }

    public List<Bet> getAllBets() {
        return repository.findAll();
    }

    public double investmentPerBetType(String betType) {
        List<Bet> betTypes = repository.findBetsByBetType(betType.toUpperCase());
        return betTypes.stream().mapToDouble(Bet::getAmount).sum();
    }

    public double investmentPerCustomerId(Long customerId) {
        List<Bet> customerIdBets = repository.findBetsByCustomerId(customerId);
        return customerIdBets.stream().mapToDouble(Bet::getAmount).sum();
    }

    public int betsSoldPerBetType(String betType) {
        return repository.findBetsByBetType(betType.toUpperCase()).size();
    }

    public int betsSoldHourly() {
        return 0;
    }

}
