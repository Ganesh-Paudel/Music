package com.senagh.music.dto;

/**
 * Artist metadata returned by the API.
 *
 * @param id generated database identifier
 * @param name artist display name
 * @param bio biography, or null when absent
 * @param image_url image URL, or null when absent
 */
public record ArtistResponse(
        Long id,
        String name,
        String bio,
        String image_url
) {
}
