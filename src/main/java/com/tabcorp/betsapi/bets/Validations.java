package com.tabcorp.betsapi.bets;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

class Validations {

    private static final Map<String, Integer> BET_TYPE = new HashMap<>();
    private static double maxAmount = 20000.00;

    static {
        BET_TYPE.put("WIN", 1);
        BET_TYPE.put("PLACE", 2);
        BET_TYPE.put("TRIFECTA", 3);
        BET_TYPE.put("DOUBLE", 4);
        BET_TYPE.put("QUADDIE", 5);
    }

    static boolean isBetValid(Bet bet) {
        return (
                isBetTypeValid(bet.getBetType())
                && !exceedsMaxAmount(bet.getAmount())
                && isDateValid(bet.getDateTime())
        );
    }

    private static boolean isBetTypeValid(String betType) {
        return BET_TYPE.containsKey(betType.toUpperCase());
    }

    private static boolean exceedsMaxAmount(double betAmount) {
        return betAmount > maxAmount;
    }



    /**
     * If the duration between bet posted and current time is more than 30 secs, a bet is deemed invalid.
     * This is to prevent bets that were created in the past from being posted.
     */
    private static boolean isDateValid(LocalDateTime date) {
        LocalDateTime now = LocalDateTime.now();
        long seconds = ChronoUnit.SECONDS.between(date, now);
        return seconds < 30;
    }

    public static void changeMaxAmount(double newMaxAmount) {
        maxAmount = newMaxAmount;
    }




}
