package de.lkaktus.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StarshipDTO(
        @JsonProperty("MGLT") String maxSpeed,
        @JsonProperty("cargo_capacity") String cargoCapacity,
        String consumables,
        @JsonProperty("cost_in_credits") String constInCredits,
        String created,
        String crew,
        String edited,
        @JsonProperty("hyperdrive_rating") String hyperdriveRating,
        String length,
        String manufacturer,
        @JsonProperty("max_atmosphering_speed") String maxAtmosphericSpeed,
        String model,
        String name,
        String passengers,
        @JsonProperty("starship_class") String starshipClass,
        String url,
        String [] films,
        SearchItemDTO [] filmItems,
        String [] pilots,
        SearchItemDTO [] pilotItems
) {

}
