import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { DemandeCredit } from '../Models/DemandeCredit_Model';
@Injectable({
  providedIn: 'root'
})
export class DemandeService {
  constructor(private http:HttpClient) { }
  getDemande(): Observable<DemandeCredit[]> {
    return this.http.get<DemandeCredit[]>("http://localhost:8090/api/DemandeCredit");
  }
  addDemande(data:DemandeCredit){
    this.http.post("http://localhost:8090/api/DemandeCredit/add",data);
  }
}
