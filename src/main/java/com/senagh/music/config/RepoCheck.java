package com.senagh.music.config;

import com.senagh.music.Entity.Song;
import com.senagh.music.Repository.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/** Prints persisted song metadata at startup as a development diagnostic. */
@Configuration
public class RepoCheck {

    @Bean
    public CommandLineRunner checkSongs(
            SongRepository songRepository
    ){
        return args-> {
            List<Song> songs = songRepository.findAll();
            System.out.println("Songs: " + songs.size());

            for(Song song: songs){
                System.out.println(song.getId() + "," + song.getTitle() + "," + song.getDurationSeconds() + " seconds");
            }
        };
    }

}
