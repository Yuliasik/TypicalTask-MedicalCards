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
  private deleteSubscription: Subscription;
  private updateSubscription: Subscription;
  @Input() deleteEvent: Observable<void>;
  @Input() updateEvent: Observable<void>;

  // @Input() refreshTriger = false;
  // @Output() refreshTriger : EventEmitter<any> = new EventEmitter();

  // counter = 0;

  constructor(private patientService: PatientService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  async ngOnInit(): Promise<void> {

    await this.getAllPatients();
    await this.redirect();

    this.route.params.subscribe(() => {
      this.getAllPatients();
    })

    this.deleteSubscription = this.deleteEvent.subscribe(() => {
      this.getAllPatients();
      this.redirect();
    });

    this.updateSubscription = this.updateEvent.subscribe((id) => {
      this.getAllPatients();
      this.redirectToCurrentPatient(id);
    });

  }

  async getAllPatients() {
     this.patients = await this.patientService.findAll().toPromise();
  }

  async redirect(){
    await this.router.navigate(['patients', 'detail', (this.patients[0].id)]);
  }

  async redirectToCurrentPatient(id){
    // const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    // console.log(this.route.snapshot.paramMap.get('id'));
    await this.router.navigate(['patients', 'detail', (id)]);
  }

  // onActivate(reference): void {
  //   // console.log(reference)
  //   reference.delete.subscribe(() => {
  //     // console.log(data);
  //     this.getAllPatients();
  //   });
  // }

  // onActivate(reference, id: number): void {
  //   // console.log(reference)
  //     console.log('zazazaz')
  //   if (id == -1) {
  //     reference.delete.subscribe(() => {
  //       this.getAllPatients(this.patients[0].id);
  //     });
  //   }else{
  //     reference.update.subscribe(() => {
  //       this.getAllPatients(id);
  //     });
  //   }
  //
  //     // reference.update.subscribe((data) => {
  //     //   this.getAllPatients(data.id)
  //     // })
  //
  // }


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
