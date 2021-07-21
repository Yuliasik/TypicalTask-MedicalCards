import {Component, OnInit} from '@angular/core';
import {Patient} from "../../model/patient";
import {PatientService} from "../../service/patient-service.service";
import {ActivatedRoute, Router} from "@angular/router";
import {DeletingService} from "../../service/deleting-service.service";

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  patients: Patient[];
  idPatientToDelete: number;

  // counter = 0;

  constructor(private patientService: PatientService,
              private router: Router,
              private route: ActivatedRoute,
              private deletingService: DeletingService) {
  }

  async ngOnInit(): Promise<void> {
    this.patients = await this.patientService.findAll().toPromise();

    await this.route.params.subscribe(data => {
      this.idPatientToDelete = this.deletingService.getPatient();
      if (this.idPatientToDelete) {
        console.log(this.patients);
        this.patientService.deletePatient(this.idPatientToDelete).subscribe(() => {
        });
        this.deleteSpecificElement(this.idPatientToDelete);
        // this.patientService.findAll().subscribe(data => {
          // this.patients = data;
        // })//.toPromise();
        console.log(this.patients);
      }

      this.router.navigate(['patients', 'detail', (this.patients[0].id == null ? this.patients[1].id : this.patients[0].id)]);
    });
    // this.patients = await this.patientService.findAll().toPromise();
    await this.router.navigate(['patients', 'detail', this.patients[0].id]);
  }

  async getAllPatients() {
    this.patientService.findAll().subscribe(data => {
      this.patients = data;
    });
  }

  onActivate(reference): void {
    // console.log(reference)
    reference.delete.subscribe(() => {
      // console.log(data);
      this.getAllPatients();
    });
  }

  deleteSpecificElement(patientId: number) {
    this.patients.forEach((patient, index) => {
      if (patient.id == this.idPatientToDelete) {
        this.patients.splice(index, 1);
        return;
      }
    });
  }
}
