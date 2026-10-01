package com.senagh.music.service;

import com.senagh.music.Entity.Song;
import com.senagh.music.Repository.SongRepository;
import com.senagh.music.dto.CreateSongRequest;
import com.senagh.music.dto.SongResponse;
import com.senagh.music.exception.SongNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<SongResponse> getAllSongs(){
        List<Song> songs = songRepository.findAll();

        List<SongResponse> responses = new ArrayList<>();

        for(Song song: songs){
            SongResponse response = new SongResponse(
                    song.getId(),
                    song.getTitle(),
                    song.getDurationSeconds()
            );
            responses.add(response);
        }
        return responses;
    }

    public SongResponse createSong(CreateSongRequest request){
        Song song = new Song(
                request.title().strip(),
                request.durationseconds()
        );

        Song savedSong = songRepository.save(song);

        return new SongResponse(
                savedSong.getId(),
                savedSong.getTitle(),
                savedSong.getDurationSeconds()
        );
    }

    public SongResponse getSongById(Long id){
        Song song = songRepository.findById(id).orElseThrow(() -> new SongNotFoundException(id));

        return new SongResponse(
                song.getId(),
                song.getTitle(),
                song.getDurationSeconds()
        );
    }
}
