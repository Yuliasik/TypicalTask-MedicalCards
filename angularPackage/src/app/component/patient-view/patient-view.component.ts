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
  showUpdateForm = false;
  @Output() delete: EventEmitter<any> = new EventEmitter();
  @Output() update: EventEmitter<any> = new EventEmitter();
  patientFirstName: string;
  patientLastName: string;

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
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.patientService.getPatient(id).subscribe(data => {
      this.patient = data;
      this.age = Dayjs().diff(Dayjs(this.patient.birthday), "year");
      this.patientFirstName = this.patient.firstName;
      this.patientLastName = this.patient.lastName;
      this.showUpdateForm = false;
    });
  }

  deletePatient(): void {
    this.patientService.deletePatient(this.patient.id).subscribe(() => {
      this.delete.emit(this.patient.id);
    });
  }

  async updatePatient(patient: Patient) {
    await this.patientService.updatePatient(patient)
      .subscribe(() => {
        this.showUpdateForm = false;
        this.getPatient();
        this.update.emit(patient.id);
      });

  }
}
