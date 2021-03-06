package com.sky.service.parental.service;

import com.sky.service.parental.exception.TechnicalFailureException;
import com.sky.service.parental.exception.TitleNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParentalControlServiceTest {

    @InjectMocks
    private ParentalControlServiceImpl parentalControlService;

    @Mock
    private MovieService movieService;


    @Test
    public void shouldReturnTrue_whenMovieIsPermissible() throws TitleNotFoundException {

        when(movieService.getRating("The Jungle Book")).thenReturn(Rating.U);
        when(movieService.getRating("Home Alone")).thenReturn(Rating.PG);
        when(movieService.getRating("Junior")).thenReturn(Rating._12);

        assertThat(parentalControlService.isMoviePermissible("U", "The Jungle Book")).isTrue();
        assertThat(parentalControlService.isMoviePermissible("PG", "Home Alone")).isTrue();
        assertThat(parentalControlService.isMoviePermissible("12", "Junior")).isTrue();
    }

    @Test
    public void shouldReturnFalse_whenMovieIsImpermissible() throws TitleNotFoundException {

        when(movieService.getRating("Terminator 2: Judgement Day")).thenReturn(Rating._18);

        assertFalse(parentalControlService.isMoviePermissible("12", "Terminator 2: Judgement Day"));
    }

    @Test(expected = TitleNotFoundException.class)
    public void shouldThrowException_whenMovieNotFound() throws TitleNotFoundException {

        when(movieService.getRating("The Rain")).thenThrow(TitleNotFoundException.class);

        parentalControlService.isMoviePermissible("15", "The Rain");
    }

    @Test(expected = TechnicalFailureException.class)
    public void shouldThrowException_whenThereIsATechnicalFailure() throws TitleNotFoundException {

        when(movieService.getRating(anyString())).thenThrow(TechnicalFailureException.class);

        parentalControlService.isMoviePermissible("U", "***");
    }
}
