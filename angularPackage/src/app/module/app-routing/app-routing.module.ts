import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Routes, RouterModule} from '@angular/router';
import {PatientListComponent} from "../../component/patient-list/patient-list.component";
import {PatientViewComponent} from "../../component/patient-view/patient-view.component";

const routes: Routes = [
  {
    path: 'patients', component: PatientListComponent,
    children: [{path: 'detail/:id', component: PatientViewComponent}]
  }
  // { path: 'adduser', component: UserFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
