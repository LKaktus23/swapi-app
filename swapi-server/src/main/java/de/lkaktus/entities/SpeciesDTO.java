package de.lkaktus.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SpeciesDTO(
        @JsonProperty("average_height") String averageHeight,
        @JsonProperty("average_lifespan") String averageLifespan,
        String classification,
        String created,
        String designation,
        String edited,
        @JsonProperty("eye_colors") String eyeColors,
        @JsonProperty("hair_colors") String hairColors,
        String homeworld,
        SearchItemDTO homeworldItem,
        String language,
        String name,
        @JsonProperty("skin_colors") String skinColors,
        String url,
        String [] people,
        SearchItemDTO [] characterItems,
        String [] films,
        SearchItemDTO [] filmItems
) {

}
