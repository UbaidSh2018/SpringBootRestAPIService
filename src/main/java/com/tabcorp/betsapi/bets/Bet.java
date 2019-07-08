package com.tabcorp.betsapi.bets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bet {

    @Id
    @GeneratedValue
    private long betId;

    @Positive(message = "Please provide a digit greater than zero")
    private long customerId;

    @NotNull(message = "Please provide a Local Date Time")
    private LocalDateTime dateTime;

    @NotEmpty(message = "Please provide a Bet Type")
    private String betType;

    @Positive(message = "Please provide a Number greater than zero")
    private long propNumber;

    @DecimalMin(message = "Amount must be greater than 0.00", value = "0.00")
    private double amount;

}
