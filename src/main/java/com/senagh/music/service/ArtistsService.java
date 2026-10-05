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

/** Coordinates artist persistence and conversion to API responses. */
@Service
public class ArtistsService {

    private final ArtistsRepository artistsRepository;
    private final ArtistMapper artistMapper;

    public ArtistsService(ArtistsRepository artistsRepository, ArtistMapper artistMapper) {
        this.artistsRepository = artistsRepository;
        this.artistMapper = artistMapper;
    }

    /**
     * Returns all records without pagination or a guaranteed ordering.
     *
     * @return responses, or an empty list when no records exist
     */
    public List<ArtistResponse> getAllArtists(){
        List<Artists> artists = artistsRepository.findAll();

        List<ArtistResponse> responses = new ArrayList<>();

        for(Artists artist : artists){
            ArtistResponse response = artistMapper.toResponse(artist);
            responses.add(response);
        }

        return responses;
    }

    /**
     * Retrieves a artist by its database identifier.
     *
     * @param id non-null database identifier
     * @return the matching artist response
     * @throws ArtistNotFoundException if no record has the supplied ID
     */
    public ArtistResponse getArtistById(Long id){
        Artists artist = artistsRepository.findById(id)
                .orElseThrow(() -> new ArtistNotFoundException(id));
        return artistMapper.toResponse(artist);
    }

    /**
     * Saves a new artist from an already validated request.
     *
     * @param request non-null payload satisfying its Bean Validation constraints
     * @return saved metadata including the generated database ID
     */
    public ArtistResponse createArtist(CreateArtistRequest request){
        Artists newArtist = artistsRepository.save(artistMapper.toEntity(request));
        return  artistMapper.toResponse(newArtist);
    }
}
