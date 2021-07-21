import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Routes, RouterModule} from '@angular/router';
import {PatientListComponent} from "../../component/patient-list/patient-list.component";
import {PatientViewComponent} from "../../component/patient-view/patient-view.component";
import {CommentListComponent} from "../../component/comment-list/comment-list.component";
import {DoctorListComponent} from "../../component/doctor-list/doctor-list.component";
import {DoctorAddComponent} from "../../component/doctor-add/doctor-add.component";

// const firstPatient = '/patients/detail/1';

const routes: Routes = [
  {path: '', redirectTo: '/patients', pathMatch: 'full'},
  // {path: '**', redirectTo: '/doctors', pathMatch: 'full'},
  {path: 'patients', component: PatientListComponent},
  {path: 'patients/detail/:id', component: PatientViewComponent},
  // {path: 'patients/detail/:id/comments', component: CommentListComponent}
  {path: 'doctors', component: DoctorListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
