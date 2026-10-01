package com.senagh.music.dto;

public record SongResponse (
    Long id,
    String title,
    Integer durationSeconds
){
}
