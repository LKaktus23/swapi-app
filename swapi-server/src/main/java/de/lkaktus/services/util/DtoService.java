package de.lkaktus.services.util;

import de.lkaktus.entities.*;
import de.lkaktus.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DtoService {

    private final SwapiService swapiService;
    private final String getCharacterEnpoint = "/people/%s/";
    private final String getAllCharactersEndpoint = "/people/?page=%s";
    private final String getFilmEnpoint = "/films/%s/";
    private final String getAllFilmsEndpoint = "/films/?page=%s";
    private final String getPlanetEnpoint = "/planets/%s/";
    private final String getAllPlanetsEndpoint = "/planets/?page=%s";
    private final String getSpeciesEnpoint = "/species/%s/";
    private final String getAllSpeciesEndpoint = "/species/?page=%s";
    private final String getStarshipEnpoint = "/starships/%s/";
    private final String getAllStarshipsEndpoint = "/starships/?page=%s";
    private final String getVehicleEnpoint = "/vehicles/%s/";
    private final String getAllVehiclesEndpoint = "/vehicles/?page=%s";

    @Autowired
    public DtoService(SwapiService service){
        this.swapiService = service;
    }

    @Cacheable(value="characters")
    public List<CharacterDTO> getAllCharacters(){
        return this.swapiService.getAll(this.getAllCharactersEndpoint, new ParameterizedTypeReference<SwapiCollectionResponseDTO<CharacterDTO>>() {});
    }

    @Cacheable(value="character", key="#id")
    public CharacterDTO getCharacterById(String id){
        return this.swapiService.get(id, this.getCharacterEnpoint, new ParameterizedTypeReference<CharacterDTO>() {});
    }

    public SearchItemDTO[] getAllCharacterNamesFromUrls(String [] urls){
        if(urls == null){
            return new SearchItemDTO[0];
        }
        List<SearchItemDTO> results = new ArrayList<>();
        for(String url: urls){
            results.add(new SearchItemDTO(Helper.CHARACTER_TYPE, Helper.getIdFromUrl(url), this.getCharacterById(Helper.getIdFromUrl(url)).name()));
        }
        return results.toArray(new SearchItemDTO[0]);
    }

    @Cacheable(value="films")
    public List<FilmDTO> getAllFilms(){
        return this.swapiService.getAll(this.getAllFilmsEndpoint, new ParameterizedTypeReference<SwapiCollectionResponseDTO<FilmDTO>>() {});
    }

    @Cacheable(value="film", key="#id")
    public FilmDTO getFilmById(String id){
        return this.swapiService.get(id, this.getFilmEnpoint, new ParameterizedTypeReference<FilmDTO>() {});
    }

    public SearchItemDTO[] getAllFilmTitlesFromUrls(String [] urls){
        if(urls == null){
            return new SearchItemDTO[0];
        }
        List<SearchItemDTO> results = new ArrayList<>();
        for(String url: urls){
            results.add(new SearchItemDTO(Helper.FILM_TYPE, Helper.getIdFromUrl(url),this.getFilmById(Helper.getIdFromUrl(url)).title()));
        }
        return results.toArray(new SearchItemDTO[0]);
    }

    @Cacheable(value="planets")
    public List<PlanetDTO> getAllPlanets(){
        return this.swapiService.getAll(this.getAllPlanetsEndpoint, new ParameterizedTypeReference<SwapiCollectionResponseDTO<PlanetDTO>>() {});
    }

    @Cacheable(value="planet", key="#id")
    public PlanetDTO getPlanetById(String id){
        return this.swapiService.get(id, this.getPlanetEnpoint, new ParameterizedTypeReference<PlanetDTO>() {});
    }

    public SearchItemDTO[] getAllPlanetNamesFromUrls(String [] urls){
        if(urls == null){
            return new SearchItemDTO[0];
        }
        List<SearchItemDTO> results = new ArrayList<>();
        for(String url: urls){
            results.add(new SearchItemDTO(Helper.PLANET_TYPE, Helper.getIdFromUrl(url),this.getPlanetById(Helper.getIdFromUrl(url)).name()));
        }
        return results.toArray(new SearchItemDTO[0]);
    }

    @Cacheable(value="allSpecies")
    public List<SpeciesDTO> getAllSpecies(){
        return this.swapiService.getAll(this.getAllSpeciesEndpoint, new ParameterizedTypeReference<SwapiCollectionResponseDTO<SpeciesDTO>>() {});
    }

    @Cacheable(value="species", key="#id")
    public SpeciesDTO getSpeciesById(String id){
        return this.swapiService.get(id, this.getSpeciesEnpoint, new ParameterizedTypeReference<SpeciesDTO>() {});
    }

    public SearchItemDTO[] getAllSpeciesNamesFromUrls(String [] urls){
        if(urls == null){
            return new SearchItemDTO[0];
        }
        List<SearchItemDTO> results = new ArrayList<>();
        for(String url: urls){
            results.add(new SearchItemDTO(Helper.SPECIES_TYPE, Helper.getIdFromUrl(url), this.getSpeciesById(Helper.getIdFromUrl(url)).name()));
        }
        return results.toArray(new SearchItemDTO[0]);
    }

    @Cacheable(value="starships")
    public List<StarshipDTO> getAllStarships(){
        return this.swapiService.getAll(this.getAllStarshipsEndpoint, new ParameterizedTypeReference<SwapiCollectionResponseDTO<StarshipDTO>>() {});
    }

    @Cacheable(value="starship", key="#id")
    public StarshipDTO getStarshipById(String id){
        return this.swapiService.get(id, this.getStarshipEnpoint, new ParameterizedTypeReference<StarshipDTO>() {});
    }

    public SearchItemDTO[] getAllStarshipNamesFromUrls(String [] urls){
        if(urls == null){
            return new SearchItemDTO[0];
        }
        List<SearchItemDTO> results = new ArrayList<>();
        for(String url: urls){
            results.add(new SearchItemDTO(Helper.STARSHIP_TYPE, Helper.getIdFromUrl(url), this.getStarshipById(Helper.getIdFromUrl(url)).name()));
        }
        return results.toArray(new SearchItemDTO[0]);
    }

    @Cacheable(value="vehicles")
    public List<VehicleDTO> getAllVehicles(){
        return this.swapiService.getAll(this.getAllVehiclesEndpoint, new ParameterizedTypeReference<SwapiCollectionResponseDTO<VehicleDTO>>() {});
    }

    @Cacheable(value="vehicle", key="#id")
    public VehicleDTO getVehicleById(String id){
        return this.swapiService.get(id, this.getVehicleEnpoint, new ParameterizedTypeReference<VehicleDTO>() {});
    }

    public SearchItemDTO[] getAllVehicleNamesFromUrls(String [] urls){
        if(urls == null){
            return new SearchItemDTO[0];
        }
        List<SearchItemDTO> results = new ArrayList<>();
        for(String url: urls){
            results.add(new SearchItemDTO(Helper.VEHICLE_TYPE,Helper.getIdFromUrl(url),this.getVehicleById(Helper.getIdFromUrl(url)).name()));
        }
        return results.toArray(new SearchItemDTO[0]);
    }
}
