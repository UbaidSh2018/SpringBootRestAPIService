package com.tabcorp.betsapi;

import com.tabcorp.betsapi.bets.Bet;
import com.tabcorp.betsapi.bets.BetsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootApplication
public class BetsapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetsapiApplication.class, args);
		Date date = new Date();
		System.out.println("dateee" + date);

	}
}
