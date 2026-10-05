package com.senagh.music.mapper;

import com.senagh.music.Entity.Artists;
import com.senagh.music.dto.ArtistResponse;
import com.senagh.music.dto.CreateArtistRequest;
import org.springframework.stereotype.Component;

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

    public Artists toEntity(CreateArtistRequest artistRequest){
        return new Artists(
               artistRequest.name().strip(),
               artistRequest.bio() == null ? null : artistRequest.bio().strip(),
               artistRequest.image_url() == null ? null : artistRequest.image_url().strip()
        );
    }
}
