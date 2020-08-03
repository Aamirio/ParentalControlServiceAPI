package com.sky.service.parental.service;

import com.sky.service.parental.exception.TechnicalFailureException;
import com.sky.service.parental.exception.TitleNotFoundException;

/**
 * Gets rating for a given movie.
 */
public interface MovieService {

    /**
     * Returns parental control level (Rating) for a given movie
     * @param movieId id of movie
     * @return Rating for a given movie.
     * @throws TitleNotFoundException If movie is not found.
     * @throws TechnicalFailureException If a runtime error occurs.
     */
    Rating getRating(String movieId) throws TitleNotFoundException, TechnicalFailureException;
}
