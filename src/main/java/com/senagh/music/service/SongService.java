package com.senagh.music.service;

import com.senagh.music.Entity.Song;
import com.senagh.music.Repository.SongRepository;
import com.senagh.music.dto.CreateSongRequest;
import com.senagh.music.dto.SongResponse;
import com.senagh.music.exception.SongNotFoundException;
import com.senagh.music.mapper.SongMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;

    public SongService(SongRepository songRepository, SongMapper songMapper) {
        this.songRepository = songRepository;
        this.songMapper = songMapper;
    }

    public List<SongResponse> getAllSongs(){
        List<Song> songs = songRepository.findAll();

        List<SongResponse> responses = new ArrayList<>();

        for(Song song: songs){
            SongResponse response = songMapper.toResponse(song);
            responses.add(response);
        }
        return responses;
    }

    public SongResponse createSong(CreateSongRequest request){

        Song savedSong = songRepository.save(songMapper.toEntity(request));

        return songMapper.toResponse(savedSong);
    }

    public SongResponse getSongById(Long id){
        Song song = songRepository.findById(id).orElseThrow(() -> new SongNotFoundException(id));

        return songMapper.toResponse(song);
    }
}
