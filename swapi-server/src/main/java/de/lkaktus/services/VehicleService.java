package de.lkaktus.services;

import de.lkaktus.entities.SearchItemDTO;
import de.lkaktus.entities.VehicleDTO;
import de.lkaktus.services.util.DtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final DtoService dtoService;

    @Autowired
    public VehicleService(DtoService dtoService){
        this.dtoService = dtoService;
    }

    public VehicleDTO getVehicleById(String id){
        VehicleDTO vehicleDTO = this.dtoService.getVehicleById(id);
        SearchItemDTO[] filmNames = this.dtoService.getAllFilmTitlesFromUrls(vehicleDTO.films());
        SearchItemDTO [] characterNames = this.dtoService.getAllCharacterNamesFromUrls(vehicleDTO.pilots());
        return new VehicleDTO(vehicleDTO.consumables(), vehicleDTO.constInCredits(), vehicleDTO.created(), vehicleDTO.crew(), vehicleDTO.edited(), vehicleDTO.length(), vehicleDTO.manufacturer(), vehicleDTO.maxAtmospheringSpeed(), vehicleDTO.model(), vehicleDTO.name(), vehicleDTO.passengers(), vehicleDTO.vehicleClass(), vehicleDTO.url(), null, filmNames, null, characterNames);
    }
}
