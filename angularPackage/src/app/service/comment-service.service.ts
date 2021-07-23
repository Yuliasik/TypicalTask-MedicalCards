import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Comment} from "../model/comment";

@Injectable()
export class CommentService {

  private patientsUrl: string;
  // private commentUrl: string;

  constructor(private http: HttpClient) {
    this.patientsUrl = 'http://localhost:9091/patients/detail';
    // this.commentUrl = 'http://localhost:9091/comments';
  }

  public getCommentByPatientId(id: number): Observable<Comment[]> {
    return this.http.get<Comment[]>(`${this.patientsUrl}/${id}/comments`);
  }

  public addComment(comment: Comment, id: number) {
    return this.http.post(`${this.patientsUrl}/${id}/comments`, comment);
  }

  public updateComment(comment: Comment, id: number) {
    return this.http.put(`${this.patientsUrl}/${id}/comments`, comment);
  }

  public getAvailableId(): Observable<number>{
    return this.http.get<number>(`${this.patientsUrl}/comments/available_id`);
  }

}
