package com.senagh.music.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Artist creation payload.
 *
 * @param name required display name, at most 50 characters
 * @param bio optional biography; may be null
 * @param image_url optional image URL; may be null and is not validated as a URL
 */
public record CreateArtistRequest(
        @NotBlank(message = "Name is required")
        @Size(max = 50, message = "At most 50 characters long")
        String name,

        String bio,
        String image_url
) {
}
