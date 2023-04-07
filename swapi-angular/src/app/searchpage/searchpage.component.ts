import { Component } from '@angular/core';
import {SearchControllerService} from "../api";
import {Subscription} from "rxjs";

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
  constructor(private readonly searchControllerService:SearchControllerService) {}
  ngOnInit() {
    this.sub = this.searchControllerService?.getAllSearchItems().subscribe(result =>{
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
    if(potentialHits.length === 1 && potentialHits[0].name.toUpperCase() === this.searchTerm.toUpperCase()){
      //HIT!
    }
  }

  filterList(){
    return this.searchItems.filter((searchItem: any) => searchItem.name.toUpperCase().includes(this.searchTerm.toUpperCase()));
  }

  ngOnDestroy() {
    this.sub?.unsubscribe();
  }
}
