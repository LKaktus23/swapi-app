package de.lkaktus.controller;

import de.lkaktus.entities.StarshipDTO;
import de.lkaktus.services.StarshipService;
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

@RequestMapping("/api/starships")
@RestController
public class StarshipController {

    private final StarshipService starshipService;

    @Autowired
    public StarshipController(StarshipService starshipService){
        this.starshipService = starshipService;
    }

    @GetMapping("/get")
    @Operation(summary = "Returns the starship to the ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Everything works fine",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StarshipDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "there is no starship for given id",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unknown internal error occured",
                    content = @Content),
            @ApiResponse(responseCode = "503", description = "swapi is not available",
                    content = @Content)})
    public StarshipDTO getStarship(@RequestParam String id){
        return this.starshipService.getStarshipById(id);
    }
}
