package com.senagh.music.mapper;

import com.senagh.music.Entity.Artists;
import com.senagh.music.dto.ArtistResponse;
import com.senagh.music.dto.CreateArtistRequest;
import org.springframework.stereotype.Component;

/** Converts artist API models and entities without performing database lookups. */
@Component
public class ArtistMapper {

    public ArtistResponse toResponse(Artists artist){
        return new ArtistResponse(
                artist.getId(),
                artist.getName(),
                artist.getBio(),
                artist.getImageUrl()
        );
    }

    /**
     * Creates an unsaved artist with surrounding text whitespace stripped.
     * Optional biography and image URL values remain null when omitted.
     *
     * @param artistRequest non-null request whose fields have passed validation
     * @return a new entity without a generated ID
     */
    public Artists toEntity(CreateArtistRequest artistRequest){
        return new Artists(
               artistRequest.name().strip(),
               artistRequest.bio() == null ? null : artistRequest.bio().strip(),
               artistRequest.image_url() == null ? null : artistRequest.image_url().strip()
        );
    }
}
