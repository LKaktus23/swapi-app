package de.lkaktus.controller;

import de.lkaktus.entities.CharacterDTO;
import de.lkaktus.services.CharacterService;
import de.lkaktus.services.util.DtoService;
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

import java.util.List;

@RequestMapping("/api/characters")
@RestController
public class CharacterController {
    private final DtoService dtoService;
    private final CharacterService characterService;

    @Autowired
    public CharacterController(DtoService dtoService, CharacterService characterService){
        this.dtoService = dtoService;
        this.characterService = characterService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all available characters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Everything works fine",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CharacterDTO[].class)) }),
            @ApiResponse(responseCode = "500", description = "Unknown internal error occured",
                    content = @Content),
            @ApiResponse(responseCode = "503", description = "swapi is not available",
                    content = @Content)})
    public List<CharacterDTO> getAllCharacters(){
        return this.dtoService.getAllCharacters();
    }

    @GetMapping("/get")
    @Operation(summary = "Returns the character to the ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Everything works fine",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CharacterDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "there is no character for given id",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unknown internal error occured",
                    content = @Content),
            @ApiResponse(responseCode = "503", description = "swapi is not available",
                    content = @Content)})
    public CharacterDTO getCharacter(@RequestParam String id){
        return this.characterService.getCharacterByID(id);
    }
}
