package com.senagh.music.Repository;

import com.senagh.music.Entity.Artists;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistsRepository extends JpaRepository<Artists, Long> {
}
