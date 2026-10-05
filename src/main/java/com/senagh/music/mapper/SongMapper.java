package com.senagh.music.mapper;

import com.senagh.music.Entity.Song;
import com.senagh.music.dto.CreateSongRequest;
import com.senagh.music.dto.SongResponse;
import org.springframework.stereotype.Component;

/** Converts song API models and entities without performing database lookups. */
@Component
public class SongMapper {

    public SongResponse toResponse(Song song) {
        return new SongResponse(
                song.getId(),
                song.getTitle(),
                song.getDurationSeconds()
        );
    }

    /**
     * Creates an unsaved song with surrounding text whitespace stripped.
     * No album is assigned by this conversion.
     *
     * @param createSongRequest non-null request whose fields have passed validation
     * @return a new entity without a generated ID
     */
    public Song toEntity(CreateSongRequest createSongRequest) {
        return new Song(
                createSongRequest.title().strip(),
                createSongRequest.durationseconds()
        );
    }
}
