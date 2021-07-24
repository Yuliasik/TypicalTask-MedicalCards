import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Comment} from "../model/comment";

@Injectable()
export class CommentService {

  private patientsUrl: string;
  private comentsUrl: string;

  constructor(private http: HttpClient) {
    this.patientsUrl = 'http://localhost:9091/patients/detail';
    this.comentsUrl = 'http://localhost:9091/comments';
  }

  public getCommentByPatientId(id: number): Observable<Comment[]> {
    return this.http.get<Comment[]>(`${this.patientsUrl}/${id}/comments`);
  }

  public addComment(comment: Comment): Observable<Comment> {
    return this.http.post<Comment>(`${this.comentsUrl}/add`, comment);
  }

  public updateComment(comment: Comment) {
    return this.http.put(`${this.comentsUrl}/update`, comment);
  }
}
