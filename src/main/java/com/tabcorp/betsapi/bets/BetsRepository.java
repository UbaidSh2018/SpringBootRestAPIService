package com.tabcorp.betsapi.bets;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetsRepository extends JpaRepository<Bet, Long> {

}
