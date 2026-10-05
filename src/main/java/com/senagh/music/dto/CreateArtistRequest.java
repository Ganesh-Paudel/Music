package com.senagh.music.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateArtistRequest(
        @NotBlank(message = "Name is required")
        @Size(max = 50, message = "At most 50 characters long")
        String name,

        String bio,
        String image_url
) {
}
