package de.lkaktus.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PlanetDTO(
        String climate,
        String created,
        String diameter,
        String edited,
        String gravity,
        String name,
        @JsonProperty("orbital_period") String orbitalPeriod,
        String population,
        @JsonProperty("rotation_period") String rotationPeriod,
        @JsonProperty("surface_water") String surfaceWater,
        String terrain,
        String url,
        String [] films,
        SearchItemDTO [] filmItems,
        String [] residents,
        SearchItemDTO [] residentItems
) {

}
