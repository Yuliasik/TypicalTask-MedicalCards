import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Patient} from "../model/patient";

@Injectable()
export class PatientService {

  private patientsUrl: string;

  constructor(private http: HttpClient) {
    this.patientsUrl = 'http://localhost:9091/patients';
  }

  public findAll(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.patientsUrl);
  }

  public getPatient(id: number): Observable<Patient> {
    return this.http.get<Patient>(`${this.patientsUrl}/${id}`);
  }

  public deletePatient(id: number){
    console.log(id)
     return this.http.delete(`${this.patientsUrl}/${id}`);
  }


}
