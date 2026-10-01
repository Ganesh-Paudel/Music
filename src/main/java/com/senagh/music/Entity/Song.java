package com.senagh.music.Entity;

import jakarta.persistence.*;
import lombok.Getter;

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

    protected Song(){

    }

    public Song(String title, Integer durationSeconds){
        this.title = title;
        this.durationSeconds = durationSeconds;
    }

}
