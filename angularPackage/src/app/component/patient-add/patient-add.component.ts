import {Component, OnInit} from '@angular/core';
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

  // patient: Patient;
  // isSaveDisabled: boolean = true;
  // titleSave: string;

  constructor() {
  }

  ngOnInit() {

  }
}
