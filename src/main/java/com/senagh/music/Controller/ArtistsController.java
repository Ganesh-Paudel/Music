package com.senagh.music.Controller;

import com.senagh.music.dto.ArtistResponse;
import com.senagh.music.dto.CreateArtistRequest;
import com.senagh.music.service.ArtistsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistsController {

    private final ArtistsService artistsService;

    public ArtistsController(ArtistsService artistsService){
        this.artistsService = artistsService;
    }

    @GetMapping
    public List<ArtistResponse> getAllArtists(){
        return artistsService.getAllArtists();
    }

    @GetMapping("/{id}")
    public ArtistResponse getArtistById(@PathVariable("id") Long id){
        return artistsService.getArtistById(id);
    }

    @PostMapping
    public ResponseEntity<ArtistResponse> createArtist(@Valid @RequestBody CreateArtistRequest request){
        ArtistResponse response = artistsService.createArtist(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
