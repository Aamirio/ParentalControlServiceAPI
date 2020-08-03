package com.sky.service.parental.service;

/**
 * Checks if movie is suitable for parental control level (rating).
 */
public interface ParentalControlService {

    /**
     * Checks if movie is suitable for parental control level.
     * @param maxRating Max Rating (Parental Control Level)
     * @param movieId id of movie
     * @return true if movie is suitable for given rating, otherwise false
     */
    boolean isMoviePermissible(String maxRating, String movieId);
}
