package de.lkaktus.services;

import de.lkaktus.entities.FilmDTO;
import de.lkaktus.entities.SearchItemDTO;
import de.lkaktus.services.util.DtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    private final DtoService dtoService;

    @Autowired
    public FilmService(DtoService dtoService){
        this.dtoService = dtoService;
    }

    public FilmDTO getFilmById(String id){
        FilmDTO film = this.dtoService.getFilmById(id);
        SearchItemDTO[] characterNames = this.dtoService.getAllCharacterNamesFromUrls(film.characters());
        SearchItemDTO [] planetNames = this.dtoService.getAllPlanetNamesFromUrls(film.planets());
        SearchItemDTO [] speciesNames = this.dtoService.getAllSpeciesNamesFromUrls(film.species());
        SearchItemDTO [] starshipNames = this.dtoService.getAllStarshipNamesFromUrls(film.starships());
        SearchItemDTO [] vehicleNames = this.dtoService.getAllVehicleNamesFromUrls(film.vehicles());
        return new FilmDTO(film.created(), film.director(), film.edited(), film.episodeID(), film.openingCrawl(), film.producer(), film.releaseDate(), film.title(), film.url(), null, characterNames, null, planetNames, null, speciesNames, null, starshipNames, null, vehicleNames);
    }
}
