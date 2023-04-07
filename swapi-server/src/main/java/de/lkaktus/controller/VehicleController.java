package de.lkaktus.controller;

import de.lkaktus.entities.VehicleDTO;
import de.lkaktus.services.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/vehicles")
@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/get")
    @Operation(summary = "Returns the vehicle to the ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Everything works fine",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VehicleDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "there is no vehicle for given id",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unknown internal error occured",
                    content = @Content),
            @ApiResponse(responseCode = "503", description = "swapi is not available",
                    content = @Content)})
    public VehicleDTO getVehicle(@RequestParam String id){
        return this.vehicleService.getVehicleById(id);
    }
}
