package com.senagh.music.Entity;

import jakarta.persistence.*;
import lombok.Getter;

/** Artist metadata; biography and image URL may be absent. */
@Entity
@Table(name = "artists")
@Getter
public class Artists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false, length = 50)
    private String name;

    @Column(name="bio")
    private String bio;

    @Column(name="image_url")
    private String imageUrl;

    protected Artists(){

    }

    public Artists(String name, String bio, String imageUrl){
        this.name = name;
        this.bio = bio;
        this.imageUrl = imageUrl;
    }
}
