import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {DoctorService} from "../../service/doctor-service.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PatientService} from "../../service/patient-service.service";
import {Patient} from "../../model/patient";

@Component({
  selector: 'app-patient-add',
  templateUrl: './patient-add.component.html',
  styleUrls: ['./patient-add.component.css']
})
export class PatientAddComponent implements OnInit {

  patient: Patient = new Patient();
  @Output() create: EventEmitter<any> = new EventEmitter();
  // isSaveDisabled: boolean = true;
  // titleSave: string;

  constructor(private patientService: PatientService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.patient = new Patient();
  }

  addPatient(patient: Patient){
    console.log(patient);
    this.patientService.addNewPatient(patient)
      .subscribe((id)=>{
        this.create.emit(id);
      })
  }


}
