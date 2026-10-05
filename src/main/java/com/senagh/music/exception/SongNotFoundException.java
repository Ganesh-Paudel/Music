package com.senagh.music.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Signals an unknown song ID and maps it to HTTP 404 at the web boundary. */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SongNotFoundException extends RuntimeException{
    public SongNotFoundException(Long id) {
        super("Could not find song with id " + id);
    }
}
