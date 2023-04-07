package de.lkaktus.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CharacterDTO(
        @JsonProperty("birth_year") String birthYear,
        @JsonProperty("eye_color") String eyeColor,
        String gender,
        @JsonProperty("hair_color") String hairColor,
        String height,
        String homeworld,
        SearchItemDTO homeworldItem,
        String mass,
        String name,
        @JsonProperty("skin_color") String skinColor,
        String edited,
        String created,
        String url,
        String [] films,
        SearchItemDTO [] filmItems,
        String [] species,
        SearchItemDTO [] speciesItems,
        String [] starships,
        SearchItemDTO [] starshipItems,
        String [] vehicles,
        SearchItemDTO [] vehicleItems
        ) {
}
