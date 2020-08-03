package com.sky.service.parental.service;

/**
 * Gets rating for a given movie.
 */
public interface MovieService {

    /**
     * Returns parental control level (Rating) for a given movie
     * @param movieId id of movie
     * @return Rating for a given movie.
     */
    Rating getRating(String movieId);
}
