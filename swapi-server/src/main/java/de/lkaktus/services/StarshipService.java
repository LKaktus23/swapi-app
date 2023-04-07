package de.lkaktus.services;

import de.lkaktus.entities.SearchItemDTO;
import de.lkaktus.entities.StarshipDTO;
import de.lkaktus.services.util.DtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarshipService {

    private final DtoService dtoService;

    @Autowired
    public StarshipService(DtoService dtoService){
        this.dtoService = dtoService;
    }

    public StarshipDTO getStarshipById(String id){
        StarshipDTO starshipDTO = this.dtoService.getStarshipById(id);
        SearchItemDTO[] filmNames = this.dtoService.getAllFilmTitlesFromUrls(starshipDTO.films());
        SearchItemDTO [] characterNames = this.dtoService.getAllCharacterNamesFromUrls(starshipDTO.pilots());
        return new StarshipDTO(starshipDTO.maxSpeed(), starshipDTO.cargoCapacity(), starshipDTO.consumables(), starshipDTO.constInCredits(), starshipDTO.created(), starshipDTO.crew(), starshipDTO.edited(), starshipDTO.hyperdriveRating(), starshipDTO.length(), starshipDTO.manufacturer(), starshipDTO.maxAtmosphericSpeed(), starshipDTO.model(), starshipDTO.name(), starshipDTO.passengers(), starshipDTO.starshipClass(), starshipDTO.url(), null, filmNames, null, characterNames);
    }
}
