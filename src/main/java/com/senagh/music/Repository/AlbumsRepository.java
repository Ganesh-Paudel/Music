package com.senagh.music.Repository;

import com.senagh.music.Entity.Albums;
import org.springframework.data.jpa.repository.JpaRepository;

/** Persistence operations for albums records identified by database ID. */
public interface AlbumsRepository extends JpaRepository<Albums, Long> {
}
