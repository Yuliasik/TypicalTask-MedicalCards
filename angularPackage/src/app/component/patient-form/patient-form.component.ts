import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Patient} from "../../model/patient";
import {PatientService} from "../../service/patient-service.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-patient-form',
  templateUrl: './patient-form.component.html',
  styleUrls: ['./patient-form.component.css']
})
export class PatientFormComponent implements OnInit {

  @Input() previousPatient: Patient;
  @Output() savePatient: EventEmitter<any> = new EventEmitter();

  isSaveDisabled: boolean = true;
  titleSave: string;
  isFemale = false;
  patient: Patient;


  constructor(private patientService: PatientService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.cancelPatient();
  }

  funcCheckSex() {
    if (this.isFemale) {
      this.patient.sex = "FEMALE";
    } else {
      this.patient.sex = "MALE";
    }
    console.log(this.patient.sex)
  }

  funcIsFemale() {
    if (this.patient.sex === "FEMALE") {
      this.isFemale = true;
    } else {
      this.isFemale = false;
    }
  }

  clonePatient(oldPatient: Patient): Patient {
    let newPatient = new Patient();
    for (var attribut in oldPatient) {
      newPatient[attribut] = oldPatient[attribut];
    }
    return newPatient;
  }

  // addNewPatient() {
  //   // await this.doctorService.addNewDoctor(this.doctor);
  //   // this.save.emit(this.doctor);
  //   // this.cancelDoctor();
  // }

  async funcSavePatient() {
    console.log(this.patient);
    if (this.patient.id) {
      // await this.patientService.updatePatient(this.patient, this.patient.id)
      //   .subscribe(() => {});
    } else{
      this.savePatient.emit(this.patient);
      this.patient.id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
      await this.patientService.addNewPatient(this.patient).subscribe(() => {});
    }
    // log

  }


  cancelPatient() {
    this.patient = this.clonePatient(this.previousPatient);
    this.isSaveDisabled = true;
    this.titleSave = 'Not all fields valid or inputted';
    this.funcIsFemale();
  }

  changeForm() {
    // console.log(this.isFemale)
    if (this.patient.firstName.match(/^[A-Z][a-z]+(-[A-Z][a-z]+)?$/) &&
      this.patient.lastName.match(/^[A-Z][a-z]+(-[A-Z][a-z]+)?$/) &&
      this.patient.sex &&
      this.patient.birthday &&
      this.patient.country.match(/^[A-Z](([A-Z]+)|([a-z])+)([ -][A-Z](([A-Z]+)|([a-z])+))*$/) &&
      this.patient.state.match(/^[A-Z](([A-Z]+)|([a-z])+)([ -][A-Z](([A-Z]+)|([a-z])+))*$/) &&
      this.patient.address) {
      this.isSaveDisabled = false;
      this.titleSave = 'Save patient';

    } else {
      this.isSaveDisabled = true;
      this.titleSave = 'Not all fields valid or inputted';
    }
  }

}
