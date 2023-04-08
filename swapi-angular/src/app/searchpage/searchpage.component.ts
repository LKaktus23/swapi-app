import { Component } from '@angular/core';
import {SearchControllerService} from "../api";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-searchpage',
  templateUrl: './searchpage.component.html',
  styleUrls: ['./searchpage.component.scss']
})

export class SearchpageComponent {
  searchTerm:string = "";
  searchItems:any;
  filteredSearchItems:any = [];
  sub:Subscription|null = null;
  constructor(private readonly searchControllerService:SearchControllerService, private router: Router) {}
  ngOnInit() {
    document.getElementById("loading-bar")?.dispatchEvent(new Event("loading"));
    this.sub = this.searchControllerService?.getAllSearchItems().subscribe(result =>{
      document.getElementById("loading-bar")?.dispatchEvent(new Event("finish"));
      this.searchItems = result;
    });
  }
  onKey(value:string){
    this.searchTerm = value;
    if(this.searchTerm.length > 1){
      this.filteredSearchItems = this.filterList();
    }else{
      this.filteredSearchItems = [];
    }
  }
  onEnter(){
    const potentialHits = this.filterList();
    if(potentialHits.length === 1){
      this.router.navigate(["/details", potentialHits[0].type, potentialHits[0].id]);
    }
  }

  filterList(){
    return this.searchItems.filter((searchItem: any) => searchItem.name.toUpperCase().includes(this.searchTerm.toUpperCase()));
  }

  ngOnDestroy() {
    this.sub?.unsubscribe();
  }
}
