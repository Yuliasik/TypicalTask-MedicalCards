import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Patient} from "../../model/patient";
import {PatientService} from "../../service/patient-service.service";
import * as Dayjs from "dayjs";
import {CommentListComponent} from "../comment-list/comment-list.component";

// import {DeletingService} from "../../service/deleting-service.service";

@Component({
  selector: 'app-patient-view',
  templateUrl: './patient-view.component.html',
  styleUrls: ['./patient-view.component.css']
})
export class PatientViewComponent implements OnInit {

  patient: Patient;
  age: number;
  showUpdateForm = false;
  @Output() delete: EventEmitter<any> = new EventEmitter();
  @Output() update: EventEmitter<any> = new EventEmitter();
  patientFirstName: string;
  patientLastName: string;

  // private commentsComponent : CommentListComponent;

  constructor(private patientService: PatientService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params.subscribe(() => {
      this.getPatient();
      // this.showUpdateForm = false;
    });
  }

  getPatient(): void {
    // console.log(this.route);
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.patientService.getPatient(id).subscribe(data => {
      this.patient = data;
      this.age = Dayjs().diff(Dayjs(this.patient.birthday), "year");
      // console.log(age);
      this.patientFirstName = this.patient.firstName;
      this.patientLastName = this.patient.lastName;
      this.showUpdateForm = false;
    });
  }


  // goToParent():void{
  //   // this.router.navigateByUrl('/patients')
  //   this.delete.emit(666);
  // }

  deletePatient(): void {
    this.patientService.deletePatient(this.patient.id).subscribe(() => {
      this.delete.emit();
    });
    //   // const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    //   // this.patientService.deletePatient(this.patient.id).subscribe(() => {
    //   //  this.delete.emit();
    //   // });
    //   this.deletingService.setPatient(this.patient.id);
    //   this.router.navigate(['patients']);
  }

  async updatePatient(patient: Patient) {
    // this.patientService.
    // console.log(patient)
    // console.log(patient);

    await this.patientService.updatePatient(patient)
      .subscribe(() => {
        this.showUpdateForm = false;
        this.getPatient();
        this.update.emit(patient.id);
      });

  }

  // goToComments(id: number): void{
  //   this.router.navigateByUrl(`patients/detail/${id}/comments`)
  // }
}
