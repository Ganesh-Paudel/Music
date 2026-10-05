package com.senagh.music.Repository;

import com.senagh.music.Entity.Artists;
import org.springframework.data.jpa.repository.JpaRepository;

/** Persistence operations for artists records identified by database ID. */
public interface ArtistsRepository extends JpaRepository<Artists, Long> {
}
