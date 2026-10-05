package com.senagh.music.Repository;

import com.senagh.music.Entity.Albums;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumsRepository extends JpaRepository<Albums, Long> {
}
