import { Component } from '@angular/core';

@Component({
  selector: 'app-loadingbar',
  templateUrl: './loadingbar.component.html',
  styleUrls: ['./loadingbar.component.scss']
})
export class LoadingbarComponent {
  isLoading:boolean = false;
  finishedLoading:boolean = false;

  onStartLoading(){
    this.isLoading = true;
    this.finishedLoading = false;
  }

  onFinished(){
    this.isLoading = false;
    this.finishedLoading = true;
  }
}
