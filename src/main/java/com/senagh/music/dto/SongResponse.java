package com.senagh.music.dto;

/**
 * Song metadata returned by the API, without album details.
 *
 * @param id generated database identifier
 * @param title song title
 * @param durationSeconds duration in seconds; uses camel case in response JSON
 */
public record SongResponse (
    Long id,
    String title,
    Integer durationSeconds
){
}
