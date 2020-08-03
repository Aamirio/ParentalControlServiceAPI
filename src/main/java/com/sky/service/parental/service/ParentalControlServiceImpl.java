package com.sky.service.parental.service;

import org.springframework.stereotype.Service;

@Service
public class ParentalControlServiceImpl implements ParentalControlService {

    private final MovieService movieService;

    public ParentalControlServiceImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public boolean isMoviePermissible(String maxRating, String movieId) {

        return movieService.getRating(movieId).getNumValue() <= Rating.getNumValue(maxRating);
    }
}
