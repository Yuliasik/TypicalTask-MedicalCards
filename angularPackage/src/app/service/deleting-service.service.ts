import { Injectable } from '@angular/core';

@Injectable()
export class DeletingService {

  private idPatientToDelete: number;

  setPatient(idPatientToDelete: number){
    this.idPatientToDelete = idPatientToDelete;
  }

  getPatient():number{
    return this.idPatientToDelete;
  }
}
