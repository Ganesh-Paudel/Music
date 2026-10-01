package com.senagh.music.Controller;

import com.senagh.music.Entity.Song;
import com.senagh.music.dto.CreateSongRequest;
import com.senagh.music.dto.SongResponse;
import com.senagh.music.service.SongService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService){
        this.songService = songService;
    }

    @GetMapping
    public List<SongResponse> getAllSongs(){
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public SongResponse getSongById( @PathVariable("id") Long id){
        return songService.getSongById(id);
    }

    @PostMapping
    public ResponseEntity<SongResponse> createSong(@Valid @RequestBody CreateSongRequest request){
        SongResponse response = songService.createSong(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
