package de.lkaktus.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VehicleDTO(String consumables,
                         @JsonProperty("cost_in_credits") String constInCredits,
                         String created,
                         String crew,
                         String edited,
                         String length,
                         String manufacturer,
                         @JsonProperty("max_atmosphering_speed") String maxAtmospheringSpeed,
                         String model,
                         String name,
                         String passengers,
                         @JsonProperty("vehicle_class") String vehicleClass,
                         String url,
                         String [] films,
                         SearchItemDTO [] filmItems,
                         String [] pilots,
                         SearchItemDTO [] pilotItems
) {

}
