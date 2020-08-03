package com.sky.service.parental.service;

import com.sky.service.parental.exception.TechnicalFailureException;
import com.sky.service.parental.exception.TitleNotFoundException;
import org.springframework.stereotype.Service;

/**
 * This stubbed implementation is for purposes of demonstrating application functionality.
 */
@Service
public class MovieServiceStub implements MovieService {

    @Override
    public Rating getRating(String movieId) throws TitleNotFoundException, TechnicalFailureException {

        if (movieId.equalsIgnoreCase("alpha")) return Rating.U;
        if (movieId.equalsIgnoreCase("beta")) return Rating.PG;
        if (movieId.equalsIgnoreCase("charlie")) return Rating._12;
        if (movieId.equalsIgnoreCase("delta")) return Rating._15;
        if (movieId.equalsIgnoreCase("echo")) return Rating._18;
        if (movieId.equalsIgnoreCase( "foxtrot")) throw new TechnicalFailureException();

        else throw new TitleNotFoundException();
    }
}
