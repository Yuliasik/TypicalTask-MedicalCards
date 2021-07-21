import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Patient} from "../../model/patient";
import {PatientService} from "../../service/patient-service.service";
import * as Dayjs from "dayjs";
import {CommentListComponent} from "../comment-list/comment-list.component";
import {DeletingService} from "../../service/deleting-service.service";

@Component({
  selector: 'app-patient-view',
  templateUrl: './patient-view.component.html',
  styleUrls: ['./patient-view.component.css']
})
export class PatientViewComponent implements OnInit {

  patient: Patient;
  age: number;
  @Output() delete: EventEmitter<any> = new EventEmitter();
  // private commentsComponent : CommentListComponent;

  constructor(private patientService: PatientService,
              private router: Router,
              private route: ActivatedRoute,
              private deletingService: DeletingService) {
  }

  ngOnInit() {
    this.route.params.subscribe(()=> {
      this.getPatient();
    });
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
  //   // this.router.navigateByUrl('/patients')
  //   this.delete.emit(666);
  // }

  deletePatient(): void {
    // const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    // this.patientService.deletePatient(this.patient.id).subscribe(() => {
    //  this.delete.emit();
    // });
    this.deletingService.setPatient(this.patient.id);
    this.router.navigate(['patients']);
  }

  // goToComments(id: number): void{
  //   this.router.navigateByUrl(`patients/detail/${id}/comments`)
  // }
}
