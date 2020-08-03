package com.sky.service.parental.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Rating {

      U("U", 1),
     PG("PG", 6),
    _12("12", 12),
    _15("15", 15),
    _18("18", 18);

    private static final Map<String, Integer> ratingsWithNumValues = new HashMap<>();

    private final String rating;
    private final Integer numValue;

    static {
        Arrays.stream(Rating.values())
                .forEach(rating -> ratingsWithNumValues.put(rating.getRating(), rating.getNumValue()));
    }

    Rating(String rating, Integer numValue) {
        this.rating = rating;
        this.numValue = numValue;
    }

    /**
     * Returns numerical value of rating
     * @param rating The rating e.g. "PG"
     * @return numerical value of rating. If rating does not exist 0 is returned.
     */
    public static Integer getNumValue(String rating) {
        return ratingsWithNumValues.getOrDefault(rating, 0);
    }

    public String getRating() {
        return rating;
    }

    public Integer getNumValue() {
        return numValue;
    }

}
