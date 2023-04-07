package de.lkaktus.services;

import de.lkaktus.entities.PlanetDTO;
import de.lkaktus.entities.SearchItemDTO;
import de.lkaktus.services.util.DtoService;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    private final DtoService dtoService;

    public PlanetService(DtoService dtoService){
        this.dtoService = dtoService;
    }

    public PlanetDTO getPlanetById(String id){
        PlanetDTO planetDTO = this.dtoService.getPlanetById(id);
        SearchItemDTO[] filmTitles = this.dtoService.getAllFilmTitlesFromUrls(planetDTO.films());
        SearchItemDTO [] characterNames = this.dtoService.getAllCharacterNamesFromUrls(planetDTO.residents());
        return new PlanetDTO(planetDTO.climate(), planetDTO.created(), planetDTO.diameter(), planetDTO.edited(), planetDTO.gravity(), planetDTO.name(), planetDTO.orbitalPeriod(), planetDTO.population(), planetDTO.rotationPeriod(), planetDTO.surfaceWater(), planetDTO.terrain(), planetDTO.url(), null, filmTitles, null, characterNames);
    }
}
