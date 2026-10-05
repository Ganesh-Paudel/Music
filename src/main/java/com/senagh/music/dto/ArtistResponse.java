package com.senagh.music.dto;

public record ArtistResponse(
        Long id,
        String name,
        String bio,
        String image_url
) {
}
