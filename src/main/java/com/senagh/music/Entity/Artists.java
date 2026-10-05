package com.senagh.music.Entity;

import jakarta.persistence.*;
import lombok.Getter;

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
}
