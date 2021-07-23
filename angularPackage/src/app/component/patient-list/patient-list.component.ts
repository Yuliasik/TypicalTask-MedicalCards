import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Patient} from "../../model/patient";
import {PatientService} from "../../service/patient-service.service";
import {ActivatedRoute, Router} from "@angular/router";
// import {DeletingService} from "../../service/deleting-service.service";
import {optimizeGroupPlayer} from "@angular/animations/browser/src/render/shared";
import {Observable, Subscription} from "rxjs";

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  patients: Patient[];
  idPatientToDelete: number;
  private eventsSubscription: Subscription;
  @Input() events: Observable<void>;
  // @Input() refreshTriger = false;
  // @Output() refreshTriger : EventEmitter<any> = new EventEmitter();

  // counter = 0;

  constructor(private patientService: PatientService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  async ngOnInit(): Promise<void> {
    this.route.params.subscribe(()=>{
      this.getAllPatients();
    })
    this.eventsSubscription = this.events.subscribe(() => {
      this.getAllPatients();
    });

    await this.getAllPatients();

    //
    // await this.route.params.subscribe(data => {
    //   this.idPatientToDelete = this.deletingService.getPatient();
    //   if (this.idPatientToDelete) {
    //     console.log(this.patients);
    //     // this.patientService.deletePatient(this.idPatientToDelete).subscribe(() => {
    //     // });
    //     console.log(this.idPatientToDelete);
    //     this.deleteSpecificElement(this.idPatientToDelete);
    //     // this.patientService.findAll().subscribe(data => {
    //       // this.patients = data;
    //     // })//.toPromise();
    //     console.log(this.patients);
    //   }
    //
    //   this.router.navigate(['patients', 'detail', (this.patients[0].id == null ? this.patients[1].id : this.patients[0].id)]);
    // });
    // // this.patients = await this.patientService.findAll().toPromise();
    // await this.router.navigate(['patients', 'detail', this.patients[0].id]);
  }

  async getAllPatients() {
    // this.patientService.findAll().subscribe(data => {
    //   this.patients = data;
    // });
    this.patients = await this.patientService.findAll().toPromise();
    await this.router.navigate(['patients', 'detail', (this.patients[0].id)]);

  }

  onActivate(reference): void {
    // console.log(reference)
    reference.delete.subscribe(() => {
      // console.log(data);
      this.getAllPatients();
    });
  }


    // deleteSpecificElement(patientId: number) {
  //   this.patients.forEach((patient, index) => {
  //     if (patient.id == this.idPatientToDelete) {
  //       // this.patients.push(this.patients[index]);
  //       // this.patients[index].isShowed = false;
  //       // this.patients.splice(index, 1);
  //       // console.log(index);
  //       this.patients[index] = null;
  //       console.log(this.patients[index]);
  //       // this.patients[index].style_display = 'none';
  //       // console.log(this.patients[index].style_display);
  //       // this.patients[index].status = "d-sm-none";
  //       // this.patients[index] ;
  //       // console.log(this.patients[index]);
  //       // console.log(this.patients[index] != null ? 'block' : 'none');
  //       return;
  //     }
  //   });
  // }
}
