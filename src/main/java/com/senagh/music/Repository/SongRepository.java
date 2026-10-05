package com.senagh.music.Repository;

import com.senagh.music.Entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Persistence operations for song records identified by database ID. */
@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
