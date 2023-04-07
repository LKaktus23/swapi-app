package de.lkaktus.services;

import de.lkaktus.entities.SearchItemDTO;
import de.lkaktus.entities.SpeciesDTO;
import de.lkaktus.services.util.DtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeciesService {

    private final DtoService dtoService;

    @Autowired
    public SpeciesService(DtoService dtoService){
        this.dtoService = dtoService;
    }

    public SpeciesDTO getSpeciesById(String id){
        SpeciesDTO speciesDTO = this.dtoService.getSpeciesById(id);
        String [] homeWorldArray = {speciesDTO.homeworld()};
        SearchItemDTO homeWorld = this.dtoService.getAllPlanetNamesFromUrls(homeWorldArray)[0];
        SearchItemDTO [] characterNames = this.dtoService.getAllCharacterNamesFromUrls(speciesDTO.people());
        SearchItemDTO [] filmTitles = this.dtoService.getAllFilmTitlesFromUrls(speciesDTO.films());
        return new SpeciesDTO(speciesDTO.averageHeight(), speciesDTO.averageLifespan(), speciesDTO.classification(), speciesDTO.created(), speciesDTO.designation(), speciesDTO.edited(), speciesDTO.eyeColors(), speciesDTO.hairColors(), null, homeWorld, speciesDTO.language(), speciesDTO.name(), speciesDTO.skinColors(), speciesDTO.url(), null, characterNames, null, filmTitles);
    }
}
