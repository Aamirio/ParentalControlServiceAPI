package com.sky.service.parental.service;

import com.sky.service.parental.exception.TechnicalFailureException;
import com.sky.service.parental.exception.TitleNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ParentalControlServiceImpl implements ParentalControlService {

    private final MovieService movieService;

    public ParentalControlServiceImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public boolean isMoviePermissible(String maxRating, String movieId) throws TitleNotFoundException, TechnicalFailureException {

        return movieService.getRating(movieId).getNumValue() <= Rating.getNumValue(maxRating);
    }
}
