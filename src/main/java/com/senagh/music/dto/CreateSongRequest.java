package com.senagh.music.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * Song creation payload; album assignment is not part of this request.
 *
 * @param title required title; validation allows 200 characters, but the current
 *              entity column supports only 100
 * @param durationseconds required positive duration in seconds; this lowercase
 *                        name is the current JSON request field
 */
public record CreateSongRequest (
        @NotBlank(message = "Title is required")
        @Size(max = 200, message="Title can be at most 200 characters long")
        String title,

        @NotNull(message="Duration is required")
        @Positive(message="Duration must be a postive value >0")
        Integer durationseconds
){
}
