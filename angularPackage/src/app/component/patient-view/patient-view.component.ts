import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Patient} from "../../model/patient";
import {PatientService} from "../../service/patient-service.service";
import * as Dayjs from "dayjs";

@Component({
  selector: 'app-patient-view',
  templateUrl: './patient-view.component.html',
  styleUrls: ['./patient-view.component.css']
})
export class PatientViewComponent implements OnInit {

  patient: Patient;
  age: number;
  @Output() delete: EventEmitter<any> = new EventEmitter();

  constructor(private patientService: PatientService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params.subscribe((param) => {
      this.getPatient();
      console.log(this.route);
    })
  }

  getPatient(): void {
    // console.log(this.route);
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.patientService.getPatient(id).subscribe(data => {
      this.patient = data;
      this.age = Dayjs().diff(Dayjs(this.patient.birthday),"year");
      // console.log(age);
    });
  }



  // goToParent():void{
  //   // console.log('azazaza');
  //   // this.router.navigateByUrl('/patients')
  //   this.delete.emit(666);
  // }

  deletePatient(): void {
    // const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.patientService.deletePatient(this.patient.id).subscribe(() => {
     this.delete.emit();
    });
  }
}