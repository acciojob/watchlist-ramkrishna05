package com.driver;

public class Movie {
    private String name;
    private int DurationinMinut;
    private Double imbdRating;

    public Movie(String name, int durationinMinut, Double imbdRating) {
        this.name = name;
        DurationinMinut = durationinMinut;
        this.imbdRating = imbdRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationinMinut() {
        return DurationinMinut;
    }

    public void setDurationinMinut(int durationinMinut) {
        DurationinMinut = durationinMinut;
    }

    public Double getImbdRating() {
        return imbdRating;
    }

    public void setImbdRating(Double imbdRating) {
        this.imbdRating = imbdRating;
    }
}
