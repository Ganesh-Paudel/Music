package com.senagh.music.service;

import com.senagh.music.Entity.Artists;
import com.senagh.music.Repository.ArtistsRepository;
import com.senagh.music.dto.ArtistResponse;
import com.senagh.music.dto.CreateArtistRequest;
import com.senagh.music.exception.ArtistNotFoundException;
import com.senagh.music.mapper.ArtistMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistsService {

    private final ArtistsRepository artistsRepository;
    private final ArtistMapper artistMapper;

    public ArtistsService(ArtistsRepository artistsRepository, ArtistMapper artistMapper) {
        this.artistsRepository = artistsRepository;
        this.artistMapper = artistMapper;
    }

    public List<ArtistResponse> getAllArtists(){
        List<Artists> artists = artistsRepository.findAll();

        List<ArtistResponse> responses = new ArrayList<>();

        for(Artists artist : artists){
            ArtistResponse response = artistMapper.toResponse(artist);
            responses.add(response);
        }

        return responses;
    }

    public ArtistResponse getArtistById(Long id){
        Artists artist = artistsRepository.findById(id)
                .orElseThrow(() -> new ArtistNotFoundException(id));
        return artistMapper.toResponse(artist);
    }

    public ArtistResponse createArtist(CreateArtistRequest request){
        Artists newArtist = artistsRepository.save(artistMapper.toEntity(request));
        return  artistMapper.toResponse(newArtist);
    }
}
