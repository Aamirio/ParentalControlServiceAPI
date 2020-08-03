package com.sky.service.parental.service;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RatingEnumTest {

    @Test
    public void shouldReturnNumericalValue_whenValidRatingGiven() {

        assertThat(Rating.getNumValue("U")).isEqualTo(1);
        assertThat(Rating.getNumValue("PG")).isEqualTo(6);
        assertThat(Rating.getNumValue("12")).isEqualTo(12);
        assertThat(Rating.getNumValue("15")).isEqualTo(15);
        assertThat(Rating.getNumValue("18")).isEqualTo(18);
    }

    @Test
    public void shouldReturnZero_whenInvalidRatingGiven() {

        assertThat(Rating.getNumValue("X")).isEqualTo(0);
    }
}
