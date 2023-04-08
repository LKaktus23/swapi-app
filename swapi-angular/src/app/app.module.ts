import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SearchpageComponent } from './searchpage/searchpage.component';

import {SearchControllerService, CharacterControllerService, FilmControllerService, SpeciesControllerService, StarshipControllerService, VehicleControllerService, PlanetControllerService} from "./api";
import { DetailsComponent } from './details/details.component';
import { LoadingbarComponent } from './loadingbar/loadingbar.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SearchpageComponent,
    DetailsComponent,
    LoadingbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [SearchControllerService, CharacterControllerService, FilmControllerService, PlanetControllerService, StarshipControllerService, SpeciesControllerService, VehicleControllerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
