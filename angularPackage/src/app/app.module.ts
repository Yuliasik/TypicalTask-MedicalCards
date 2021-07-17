import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// import {MatPaginatorModule} from '@angular/material/paginator';
// import { AngularDayjsModule } from 'angular-dayjs';
// import * as dayjs from 'dayjs'


import { AppComponent } from './app.component';
// import {RouterModule} from "@angular/router";
import { PatientListComponent } from './component/patient-list/patient-list.component';
import {AppRoutingModule} from "./module/app-routing/app-routing.module";
import {HttpClientModule} from "@angular/common/http";
import {PatientService} from "./service/patient-service.service";
import { PatientViewComponent } from './component/patient-view/patient-view.component';


@NgModule({
  declarations: [
    AppComponent,
    PatientListComponent,
    PatientViewComponent,
  ],
  imports: [
    BrowserModule,
    // RouterModule,
    AppRoutingModule,
    HttpClientModule,
    // AngularDayjsModule
    // MatPaginatorModule

  ],
  providers: [PatientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
