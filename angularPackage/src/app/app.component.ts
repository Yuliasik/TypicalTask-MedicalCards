import { Component } from '@angular/core';
import {Subject} from "rxjs";
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
  // patientListReference: any;
  eventsSubject: Subject<void> = new Subject<void>();

  // public angularDayjsService: AngularDayjsService
  constructor() {
    this.title = 'MedicalCards';
  }

  onActivate(reference): void {
    // console.log(reference)
    reference.delete.subscribe(() => {
      // console.log(this.patientListReference)
      this.eventsSubject.next();

    // this.onPatientListActivate()
      // console.log(data);
      // this.getAllPatients();
    });
  }
  // onPatientListActivate(reference): void{
  //   console.log(reference)
  //   this.patientListReference = reference
  // }
  //
  // emitEventToChild() {
  //
  // }

}
