package de.lkaktus.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FilmDTO(
        String created,
        String director,
        String edited,
        @JsonProperty("episode_id") String episodeID,
        @JsonProperty("opening_crawl") String openingCrawl,
        String producer,
        @JsonProperty("release_date") String releaseDate,
        String title,
        String url,
        String [] characters,
        SearchItemDTO [] characterItems,
        String [] planets,
        SearchItemDTO [] planetItems,
        String [] species,
        SearchItemDTO [] speciesItems,
        String [] starships,
        SearchItemDTO [] starshipItems,
        String [] vehicles,
        SearchItemDTO [] vehicleItems
) {

}
