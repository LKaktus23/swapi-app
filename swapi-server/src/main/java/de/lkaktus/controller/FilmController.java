package de.lkaktus.controller;

import de.lkaktus.entities.FilmDTO;
import de.lkaktus.services.FilmService;
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

@RequestMapping("/api/films")
@RestController
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }

    @GetMapping("/get")
    @Operation(summary = "Returns the film to the ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Everything works fine",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "there is no film for given id",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unknown internal error occured",
                    content = @Content),
            @ApiResponse(responseCode = "503", description = "swapi is not available",
                    content = @Content)})
    public FilmDTO getFilm(@RequestParam String id){
        return this.filmService.getFilmById(id);
    }
}
