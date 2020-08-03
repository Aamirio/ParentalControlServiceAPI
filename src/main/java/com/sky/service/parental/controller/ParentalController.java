package com.sky.service.parental.controller;

import com.sky.service.parental.exception.TechnicalFailureException;
import com.sky.service.parental.exception.TitleNotFoundException;
import com.sky.service.parental.service.ParentalControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Hosts the HTTP endpoint.
 */
@RestController
public class ParentalController {

    @Autowired
    ParentalControlService parentalControlService;

    @GetMapping("/pc/movie/{movieId}/rating/{maxRating}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isMoviePermissible(@PathVariable String movieId, @PathVariable String maxRating
                                      ) throws TitleNotFoundException, TechnicalFailureException {

        return parentalControlService.isMoviePermissible(maxRating, movieId);
    }

    @ExceptionHandler(TitleNotFoundException.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND,reason="The movie service could not find the given movie")
    public void handleTitleNotFoundException(){}

    @ExceptionHandler(TechnicalFailureException.class)
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR,reason="System error, customer cannot watch this movie")
    public void handleTechnicalFailureException(){}

}
