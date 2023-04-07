import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SearchpageComponent } from "./searchpage/searchpage.component";
import { DetailsComponent} from "./details/details.component";

const routes: Routes = [
  {path:"", component: SearchpageComponent},
  {path:"details/:type/:id", component: DetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
