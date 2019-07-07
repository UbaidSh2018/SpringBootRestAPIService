package com.tabcorp.betsapi.reports;

import com.tabcorp.betsapi.bets.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportsRepository extends JpaRepository<Bet, Long> {
    List<Bet> findBetsByBetType(String betType);
    List<Bet> findBetsByCustomerId(Long id);
}
