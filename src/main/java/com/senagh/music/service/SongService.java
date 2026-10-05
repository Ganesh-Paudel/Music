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

/** Coordinates song persistence and conversion to API responses. */
@Service
public class SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;

    public SongService(SongRepository songRepository, SongMapper songMapper) {
        this.songRepository = songRepository;
        this.songMapper = songMapper;
    }

    /**
     * Returns all records without pagination or a guaranteed ordering.
     *
     * @return responses, or an empty list when no records exist
     */
    public List<SongResponse> getAllSongs(){
        List<Song> songs = songRepository.findAll();

        List<SongResponse> responses = new ArrayList<>();

        for(Song song: songs){
            SongResponse response = songMapper.toResponse(song);
            responses.add(response);
        }
        return responses;
    }

    /**
     * Saves a new song from an already validated request.
     *
     * @param request non-null payload satisfying its Bean Validation constraints
     * @return saved metadata including the generated database ID
     */
    public SongResponse createSong(CreateSongRequest request){

        Song savedSong = songRepository.save(songMapper.toEntity(request));

        return songMapper.toResponse(savedSong);
    }

    /**
     * Retrieves a song by its database identifier.
     *
     * @param id non-null database identifier
     * @return the matching song response
     * @throws SongNotFoundException if no record has the supplied ID
     */
    public SongResponse getSongById(Long id){
        Song song = songRepository.findById(id).orElseThrow(() -> new SongNotFoundException(id));

        return songMapper.toResponse(song);
    }
}
