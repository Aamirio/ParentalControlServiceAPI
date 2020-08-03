package com.sky.service.parental.service;

import com.sky.service.parental.exception.TechnicalFailureException;
import com.sky.service.parental.exception.TitleNotFoundException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieServiceTest {

    private final MovieService movieService = new MovieServiceStub();

    @Test
    public void shouldReturnRating_whenValidMovieGiven() throws TitleNotFoundException {

        assertThat(movieService.getRating("alpha")).isEqualTo(Rating.U);
        assertThat(movieService.getRating("echo")).isEqualTo(Rating._18);
    }

    @Test(expected = TechnicalFailureException.class)
    public void shouldThrowException_whenTechnicalFailureOccurs() throws TitleNotFoundException {

        movieService.getRating("foxtrot");
    }

    @Test(expected = TitleNotFoundException.class)
    public void shouldThrowException_whenGivenMovieDoesNotExistInLibrary() throws TitleNotFoundException {

        movieService.getRating("XXX");
    }
}
