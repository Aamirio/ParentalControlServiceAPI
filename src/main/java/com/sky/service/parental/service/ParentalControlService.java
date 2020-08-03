package com.sky.service.parental.service;

import com.sky.service.parental.exception.TechnicalFailureException;
import com.sky.service.parental.exception.TitleNotFoundException;

/**
 * Checks if movie is suitable for parental control level (rating).
 */
public interface ParentalControlService {

    /**
     * Checks if movie is suitable for parental control level.
     * @param maxRating Max Rating (Parental Control Level)
     * @param movieId id of movie
     * @return true if movie is suitable for given rating, otherwise false
     * @throws TitleNotFoundException If movie is not found.
     * @throws TechnicalFailureException If runtime error occurs.
     */
    boolean isMoviePermissible(String maxRating, String movieId) throws TitleNotFoundException, TechnicalFailureException;
}
