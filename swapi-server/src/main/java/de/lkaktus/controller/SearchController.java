package de.lkaktus.controller;

import de.lkaktus.entities.SearchItemDTO;
import de.lkaktus.services.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/search")
@RestController
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all available items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Everything works fine",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SearchItemDTO[].class)) }),
            @ApiResponse(responseCode = "500", description = "Unknown internal error occured",
                    content = @Content),
            @ApiResponse(responseCode = "503", description = "swapi is not available",
                    content = @Content)})
    public List<SearchItemDTO> getAllSearchItems(){
        return this.searchService.getAllSearchItems();
    }
}
