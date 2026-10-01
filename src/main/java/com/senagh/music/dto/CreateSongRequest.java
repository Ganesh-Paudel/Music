package com.senagh.music.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateSongRequest (
        @NotBlank(message = "Title is required")
        @Size(max = 200, message="Title can be at most 200 characters long")
        String title,

        @NotNull(message="Duration is required")
        @Positive(message="Duration must be a postive value >0")
        Integer durationseconds
){
}
