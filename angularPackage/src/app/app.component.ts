import { Component } from '@angular/core';
// import { AngularDayjsService } from 'angular-dayjs';
// import {MatTabsModule} from '@angular/material/tabs';
// import dayjs from 'dayjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string;

  // public angularDayjsService: AngularDayjsService
  constructor() {
    this.title = 'MedicalCards';
  }
}
