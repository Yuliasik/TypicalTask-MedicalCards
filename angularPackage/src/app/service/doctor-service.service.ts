import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Doctor} from "../model/doctor";
import {Patient} from "../model/patient";

@Injectable()
export class DoctorService{

  private doctorsUrl: string;

  constructor(private http: HttpClient) {
    this.doctorsUrl = 'http://localhost:9091/doctors';
  }

  public findAllDoctors(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(this.doctorsUrl);
  }
  public getDoctor(id: number): Observable<Doctor> {
    return this.http.get<Doctor>(`${this.doctorsUrl}/${id}`);
  }


}
