package com.tabcorp.betsapi.bets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Bet {

    @Id
    @GeneratedValue
    private long betId;

    private long customerId;

    private LocalDateTime dateTime;

    private String betType;

    private long propNumber;

    private double amount;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }

    public long getPropNumber() {
        return propNumber;
    }

    public void setPropNumber(long propNumber) {
        this.propNumber = propNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}