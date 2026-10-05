package com.senagh.music.mapper;

import com.senagh.music.Entity.Song;
import com.senagh.music.dto.CreateSongRequest;
import com.senagh.music.dto.SongResponse;
import org.springframework.stereotype.Component;

@Component
public class SongMapper {

    public SongResponse toResponse(Song song) {
        return new SongResponse(
                song.getId(),
                song.getTitle(),
                song.getDurationSeconds()
        );
    }

    public Song toEntity(CreateSongRequest createSongRequest) {
        return new Song(
                createSongRequest.title().strip(),
                createSongRequest.durationseconds()
        );
    }
}
