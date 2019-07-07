package com.tabcorp.betsapi.bets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BetsService {

    private BetsRepository repository;

    @Autowired
    public BetsService(BetsRepository repository) {
        this.repository = repository;
    }

    public void save(Bet bet) {
        bet.setBetType(bet.getBetType().toUpperCase());
        repository.save(bet);
    }

    public List<Bet> getAllBets() {
        return repository.findAll();
    }

}
