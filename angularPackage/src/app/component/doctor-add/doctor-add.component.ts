import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Doctor} from "../../model/doctor";
import {DoctorService} from "../../service/doctor-service.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-doctor-add',
  templateUrl: './doctor-add.component.html',
  styleUrls: ['./doctor-add.component.css']
})
export class DoctorAddComponent implements OnInit {

  @Output() save: EventEmitter<any> = new EventEmitter();
  @Input() doctor: Doctor = new Doctor();
  isSaveDisabled: boolean = true;

  constructor(private doctorService: DoctorService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.cancelDoctor();
  }

  async addNewDoctor() {
    await this.doctorService.addNewDoctor(this.doctor);
    this.save.emit(this.doctor);
    this.cancelDoctor();
  }

  cancelDoctor() {
    this.doctor = new Doctor();
    this.isSaveDisabled = true;
  }

  changeForm() {
    if (!this.doctor.firstName.match(/^\s*$/) && !this.doctor.lastName.match(/^\s*$/)) {
      this.isSaveDisabled = false;
    } else {
      this.isSaveDisabled = true;
    }
  }
}
