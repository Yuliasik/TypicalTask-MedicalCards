import {Component, Input, OnInit, SimpleChange, SimpleChanges} from '@angular/core';
import {Comment} from "../../model/comment";
import {ActivatedRoute} from "@angular/router";
import {CommentService} from "../../service/comment-service.service";
import {Doctor} from "../../model/doctor";
import {DoctorService} from "../../service/doctor-service.service";

@Component({
  selector: 'app-comment-handler',
  templateUrl: './comment-handler.component.html',
  styleUrls: ['./comment-handler.component.css']
})
export class CommentHandlerComponent implements OnInit {

  @Input() comment: Comment = new Comment();
  doctors : Doctor[] = [];
  // selectedDoctor: Doctor;

  constructor(private commentService: CommentService,
              private doctorService: DoctorService,
              private route: ActivatedRoute
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(() => {
      this.cancelComment();
    });
    this.findAllDoctors();
  }

  findAllDoctors(): void {
    this.doctorService.findAllDoctors().subscribe(data => {
      this.doctors = data;
      console.log(this.doctors);
    });
  }

  ngOnChanges(changes: SimpleChanges ){
    this.comment = changes.comment.currentValue;
    console.log(changes.comment);
  }

  async saveComment(){
    // this.comment.doctor.id =
    this.comment.doctor = this.doctorService.getDoctor(this.comment.doctor.id);
    // this.comment.doctor.firstName = "asdsad";
    // console.log(this.comment.id);
    if (this.comment.id){
      await this.commentService.updateComment(this.comment, this.comment.patient.id)
        .subscribe(data => {
        console.log(this.comment)
      });
    }else {
      this.comment.patient.id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
      await this.commentService.addComment(this.comment, this.comment.patient.id)
        .subscribe(data => {
          console.log(this.comment)
        });
    }
    // this.comment = new Comment();
    // this.ngOnInit();
    this.cancelComment();
  }

  cancelComment(){
    this.comment = new Comment();
  }
}