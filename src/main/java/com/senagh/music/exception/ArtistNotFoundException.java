package com.senagh.music.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Signals an unknown artist ID and maps it to HTTP 404 at the web boundary. */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArtistNotFoundException extends RuntimeException {

    public ArtistNotFoundException(Long id) {
        super("Could not find artist with id " + id);
    }
}
