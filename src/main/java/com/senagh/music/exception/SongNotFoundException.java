package com.senagh.music.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SongNotFoundException extends RuntimeException{
    public SongNotFoundException(Long id) {
        super("Could not find song with id " + id);
    }
}
