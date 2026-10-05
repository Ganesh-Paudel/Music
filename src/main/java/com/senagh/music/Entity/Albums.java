package com.senagh.music.Entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="albums")
@Getter
public class Albums {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable = false, length = 100)
    private String title;

    @Column(name="release_date")
    private Date releaseDate;

    @Column(name="cover_url")
    private String coverUrl;

    @OneToMany(mappedBy = "album")
    private List<Song> songs = new ArrayList<>();

}
