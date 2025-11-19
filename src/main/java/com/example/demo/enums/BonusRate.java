package com.example.demo.enums;

public enum BonusRate {

    WINTER("winter", 1.3),
    AUTUMN("autumn", 0.4),
    SPRING("spring", 0.6),
    SUMMER("summer", 0.7);

    private final String season;
    private final double rate;

    BonusRate(String season, double rate) {
        this.season = season;
        this.rate = rate;
    }

    public String getSeason() { return season; }
    public double getRate() { return rate; }

    public static BonusRate fromSeason(String season) {
        for (BonusRate b : values()) {
            if (b.season.equalsIgnoreCase(season)) return b;
        }
        throw new IllegalArgumentException("Invalid season: " + season);
    }
}
