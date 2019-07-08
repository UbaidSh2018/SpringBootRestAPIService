package com.tabcorp.betsapi.bets;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BetsRepository extends JpaRepository<Bet, Long> {

}
