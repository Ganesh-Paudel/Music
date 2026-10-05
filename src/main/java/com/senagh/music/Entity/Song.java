package com.senagh.music.Entity;

import jakarta.persistence.*;
import lombok.Getter;

/** Persisted song metadata, with an optional album association. */
@Entity
@Table(name = "songs")
@Getter
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable = false, length = 100)
    private String title;

    @Column(name="duration_seconds", nullable = false)
    private Integer durationSeconds;

    // This side owns songs.album_id; assigning an album determines the stored foreign key.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Albums album;

    protected Song(){

    }

    public Song(String title, Integer durationSeconds){
        this.title = title;
        this.durationSeconds = durationSeconds;
    }

}
