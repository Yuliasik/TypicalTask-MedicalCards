import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Patient} from "../model/patient";
import {of} from "rxjs/observable/of";
import {tap} from "rxjs/operators";

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

  public deletePatient(id: number) {
    // console.log(id)
    return this.http.delete(`${this.patientsUrl}/${id}`);
  }

  public addNewPatient(patient: Patient): Observable<Number>{
    return this.http.post<Number>(`${this.patientsUrl}`, patient);
  }

  public updatePatient(patient: Patient){
   return this.http.put<Patient>(`${this.patientsUrl}`, patient);
  }

  searchPatient(term: string): Observable<Patient[]> {
    console.log('term='+term);
    if (!term.trim()) {
      // if not search term, return empty hero array.
      return of([]);
    }
    return this.http.get<Patient[]>(`${this.patientsUrl}/byname/${term}`).pipe(
      tap(x => x.length ?
        console.log(`found heroes matching "${term}"`) :
        console.log(`no heroes matching "${term}"`))
    );
  }


}
