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
    return this.http.get<DemandeCredit[]>("http://localhost:9092/api/DemandeCredit");
  }
  addDemande(data:DemandeCredit):Observable<any>{
   return this.http.post("http://localhost:9092/api/DemandeCredit/add",data);
  }
}
