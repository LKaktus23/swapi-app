package de.lkaktus.services;

import de.lkaktus.entities.*;
import de.lkaktus.services.util.DtoService;
import de.lkaktus.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private final DtoService dtoService;

    @Autowired
    public SearchService(DtoService dtoService){
        this.dtoService = dtoService;
    }

    @Cacheable(value = "searchItems")
    public List<SearchItemDTO> getAllSearchItems(){
        List<SearchItemDTO> searchItemDTOList = new ArrayList<>(this.prepareCharacters());
        searchItemDTOList.addAll(this.prepareFilms());
        searchItemDTOList.addAll(this.preparePlanets());
        searchItemDTOList.addAll(this.prepareSpecies());
        searchItemDTOList.addAll(this.prepareStarships());
        searchItemDTOList.addAll(this.prepareVehicles());
        return searchItemDTOList;
    }

    private List<SearchItemDTO> prepareCharacters(){
        List<CharacterDTO> characterDTOList = this.dtoService.getAllCharacters();
        List<SearchItemDTO> searchItemDTOList = new ArrayList<>();
        SearchItemDTO searchItemDTO;
        for(CharacterDTO characterDTO: characterDTOList){
            searchItemDTO = new SearchItemDTO("character", Helper.getIdFromUrl(characterDTO.url()), characterDTO.name());
            searchItemDTOList.add(searchItemDTO);
        }
        return searchItemDTOList;
    }

    private List<SearchItemDTO> prepareFilms(){
        List<FilmDTO> filmDTOList = this.dtoService.getAllFilms();
        List<SearchItemDTO> searchItemDTOList = new ArrayList<>();
        SearchItemDTO searchItemDTO;
        for(FilmDTO filmDTO: filmDTOList){
            searchItemDTO = new SearchItemDTO("film", Helper.getIdFromUrl(filmDTO.url()), filmDTO.title());
            searchItemDTOList.add(searchItemDTO);
        }
        return searchItemDTOList;
    }

    private List<SearchItemDTO> preparePlanets(){
        List<PlanetDTO> planetDTOList = this.dtoService.getAllPlanets();
        List<SearchItemDTO> searchItemDTOList = new ArrayList<>();
        SearchItemDTO searchItemDTO;
        for(PlanetDTO planetDTO: planetDTOList){
            searchItemDTO = new SearchItemDTO("planet", Helper.getIdFromUrl(planetDTO.url()), planetDTO.name());
            searchItemDTOList.add(searchItemDTO);
        }
        return searchItemDTOList;
    }

    private List<SearchItemDTO> prepareSpecies(){
        List<SpeciesDTO> speciesDTOList = this.dtoService.getAllSpecies();
        List<SearchItemDTO> searchItemDTOList = new ArrayList<>();
        SearchItemDTO searchItemDTO;
        for(SpeciesDTO speciesDTO: speciesDTOList){
            searchItemDTO = new SearchItemDTO("species", Helper.getIdFromUrl(speciesDTO.url()), speciesDTO.name());
            searchItemDTOList.add(searchItemDTO);
        }
        return searchItemDTOList;
    }

    private List<SearchItemDTO> prepareStarships(){
        List<StarshipDTO> starshipDTOList = this.dtoService.getAllStarships();
        List<SearchItemDTO> searchItemDTOList = new ArrayList<>();
        SearchItemDTO searchItemDTO;
        for(StarshipDTO starshipDTO: starshipDTOList){
            searchItemDTO = new SearchItemDTO("starship", Helper.getIdFromUrl(starshipDTO.url()), starshipDTO.name());
            searchItemDTOList.add(searchItemDTO);
        }
        return searchItemDTOList;
    }

    private List<SearchItemDTO> prepareVehicles(){
        List<VehicleDTO> vehicleDTOList = this.dtoService.getAllVehicles();
        List<SearchItemDTO> searchItemDTOList = new ArrayList<>();
        SearchItemDTO searchItemDTO;
        for(VehicleDTO vehicleDTO: vehicleDTOList){
            searchItemDTO = new SearchItemDTO("vehicle", Helper.getIdFromUrl(vehicleDTO.url()), vehicleDTO.name());
            searchItemDTOList.add(searchItemDTO);
        }
        return searchItemDTOList;
    }
}
