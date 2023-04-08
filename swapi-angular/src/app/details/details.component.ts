import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {
  CharacterControllerService, CharacterDTO,
  FilmControllerService, FilmDTO,
  PlanetControllerService, PlanetDTO, SearchItemDTO, SpeciesControllerService, SpeciesDTO,
  StarshipControllerService, StarshipDTO, VehicleControllerService, VehicleDTO
} from "../api";
import {Observable, Subscription} from "rxjs";

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent {
  id:string = "";
  type:string = "";
  dto:CharacterDTO|FilmDTO|PlanetDTO|SpeciesDTO|StarshipDTO|VehicleDTO|null = null;
  subs:Array<Subscription> = [];
  readonly linkKeys:Array<String> = ["homeworldItem", "filmItems", "speciesItems", "starshipItems", "vehicleItems", "residentItems", "characterItems", "planetItems", "pilotItems"];

  constructor(
    private route: ActivatedRoute,
    private readonly characterControllerService:CharacterControllerService,
    private readonly filmControllerService:FilmControllerService,
    private readonly planetControllerService:PlanetControllerService,
    private readonly starshipControllerService:StarshipControllerService,
    private readonly speciesControllerService: SpeciesControllerService,
    private readonly vehicleControllerService: VehicleControllerService
  ) {}

  ngOnInit() {
    document.getElementById("loading-bar")?.dispatchEvent(new Event("loading"));
    this.subs.push(this.route.params.subscribe(params => {
      this.id = params['id'];
      this.type = params['type'];
      switch (this.type) {
        case "character":{
          this.subs.push(this.characterControllerService.getCharacter(this.id).subscribe(result =>{
            document.getElementById("loading-bar")?.dispatchEvent(new Event("finish"));
            this.dto = result;
          }));
          break;
        }
        case "film":{
          this.subs.push(this.filmControllerService.getFilm(this.id).subscribe(result =>{
            document.getElementById("loading-bar")?.dispatchEvent(new Event("finish"));
            this.dto = result;
          }));
          break;
        }
        case "planet":{
          this.subs.push(this.planetControllerService.getPlanet(this.id).subscribe(result =>{
            document.getElementById("loading-bar")?.dispatchEvent(new Event("finish"));
            this.dto = result;
          }));
          break;
        }
        case "species":{
          this.subs.push(this.speciesControllerService.getSpecies(this.id).subscribe(result =>{
            document.getElementById("loading-bar")?.dispatchEvent(new Event("finish"));
            this.dto = result;
          }));
          break;
        }
        case "starship":{
          this.subs.push(this.starshipControllerService.getStarship(this.id).subscribe(result =>{
            document.getElementById("loading-bar")?.dispatchEvent(new Event("finish"));
            this.dto = result;
          }));
          break;
        }
        case "vehicle":{
          this.subs.push(this.vehicleControllerService.getVehicle(this.id).subscribe(result =>{
            document.getElementById("loading-bar")?.dispatchEvent(new Event("finish"));
            this.dto = result;
          }));
          break;
        }
      }
    }));
  }

  ngOnDestroy() {
    this.subs.forEach((sub: Subscription) =>{
      sub.unsubscribe();
    })
  }

  toHumanReadableString(value:string):string{
    if(value === null){
      return "N/A";
    }
    if(this.linkKeys.includes(value)){
      value = value.replace(!value.toLowerCase().includes("species") ? "Item" : "Items", "");
    }
    value = value.replaceAll("_", " ");
    return value.charAt(0).toUpperCase() + value.substring(1);
  }

  getName(){
    if(this.dto === null){
      return null;
    }
    return this.type === "film" ? (this.dto as FilmDTO).title : (this.dto as CharacterDTO|PlanetDTO|SpeciesDTO|StarshipDTO|VehicleDTO).name
  }

  getKeys(){
    if(this.dto === null){
      return null;
    }
    let keys:string[] = Object.keys(this.dto as CharacterDTO|FilmDTO|PlanetDTO|SpeciesDTO|StarshipDTO|VehicleDTO);
    const disallowedKeys = ["title", "name", "homeworld", "url", "films", "species", "starships", "vehicles", "residents", "characters", "planets", "pilots"];
    return keys.filter((key) => {
      if(!disallowedKeys.includes(key)){
        if(this.linkKeys.includes(key)){
          return this.getSearchItemDtos(key).length > 0;
        }
        return true;
      }
      return false;
    });
  }

  getString(key:string){
    // @ts-ignore
    return this.dto[key];
  }

  getSearchItemDtos(key:string){
    // @ts-ignore
    let value:SearchItemDTO|Array<SearchItemDTO> = this.dto[key];
    if(!Array.isArray(value)){
      value = [value];
    }
    return value;
  }
}
