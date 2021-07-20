import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Routes, RouterModule} from '@angular/router';
import {PatientListComponent} from "../../component/patient-list/patient-list.component";
import {PatientViewComponent} from "../../component/patient-view/patient-view.component";
import {CommentListComponent} from "../../component/comment-list/comment-list.component";
import {DoctorListComponent} from "../../component/doctor-list/doctor-list.component";

const routes: Routes = [
  {path: '', redirectTo: '/patients', pathMatch: 'full'},
  {
    path: 'patients', component: PatientListComponent,
    children: [{path: 'detail/:id', component: PatientViewComponent},
      {path: 'doctors', component: DoctorListComponent }
    ]
      // children:[{path: 'comments', component: CommentListComponent}]}]
    // children: [{path: 'detail/:id', component: PatientViewComponent}]
  },
  // {path: 'patients/detail/:id/comments', component: CommentListComponent}
  {path: 'doctors', component: DoctorListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
