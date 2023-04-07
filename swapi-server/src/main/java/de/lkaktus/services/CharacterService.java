package de.lkaktus.services;

import de.lkaktus.entities.CharacterDTO;
import de.lkaktus.entities.SearchItemDTO;
import de.lkaktus.services.util.DtoService;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private final DtoService dtoService;

    public CharacterService(DtoService dtoService){
        this.dtoService = dtoService;
    }

    public CharacterDTO getCharacterByID(String id){
        CharacterDTO character = this.dtoService.getCharacterById(id);
        String [] homeWorldArray = {character.homeworld()};
        SearchItemDTO homeWorld = this.dtoService.getAllPlanetNamesFromUrls(homeWorldArray)[0];
        SearchItemDTO [] filmNames = this.dtoService.getAllFilmTitlesFromUrls(character.films());
        SearchItemDTO [] speciesNames = this.dtoService.getAllSpeciesNamesFromUrls(character.species());
        SearchItemDTO [] starshipNames = this.dtoService.getAllStarshipNamesFromUrls(character.starships());
        SearchItemDTO [] vehicleNames = this.dtoService.getAllVehicleNamesFromUrls(character.vehicles());
        return new CharacterDTO(character.birthYear(), character.eyeColor(), character.gender(), character.hairColor(), character.height(), null, homeWorld, character.mass(), character.name(), character.skinColor(), character.edited(), character.created(), character.url(), null,filmNames,null, speciesNames, null,starshipNames, null,vehicleNames);
    }
}
