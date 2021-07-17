import { Component, OnInit } from '@angular/core';
import {Patient} from "../../model/patient";
import {PatientService} from "../../service/patient-service.service";
import {ActivatedRoute, Router} from "@angular/router";
import * as Dayjs from "dayjs";

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  // showPatientDetails
  patients: Patient[];

  counter = 0;

  constructor(private patientService: PatientService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    // const a = {
    //   id: 1,
    //   name: 'Name'
    // }
    // const {id} = a;

    // this.route.url.subscribe()
    // this.route.url.subscribe((param) => {
      // console.log(param)
      // if(param[0].path === 'patients'){
        this.getAllPatients();
      // }
    // })
  }

  getAllPatients():void{
    this.patientService.findAll().subscribe(data => {
      this.patients = data;
      this.goToDetail(this.patients[0].id);
    });
  }

  goToDetail(id: number): void{
    this.router.navigateByUrl(`patients/detail/${id}`)
  }

  increment(): void{
    this.counter++;
  }

  onActivate(reference): void{
    console.log(reference)
    reference.delete.subscribe(() => {
      // console.log(data);
      this.getAllPatients();
    });
  }
  readableDate(date: string){
    console.log(date);
  }

}
