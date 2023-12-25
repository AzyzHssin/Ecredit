import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { DemandeCredit } from '../Models/DemandeCredit_Model';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class DemandeService {
  constructor(private http:HttpClient) { }
  private baseUrl = 'http://localhost:9092/api/DemandeCredit';
  getDemande(): Observable<DemandeCredit[]> {
    return this.http.get<DemandeCredit[]>(`${this.baseUrl}`);
  }
  addDemande(data:DemandeCredit):Observable<any>{
   return this.http.post(`${this.baseUrl}/add`,data);
  }
  updateDemande(object:DemandeCredit,nouveauEtat:String){
    const requestBody = { "demande": object, "nouvelEtat": nouveauEtat };
    console.log("requestBody: ",requestBody)
    return this.http.put(`${this.baseUrl}/update`,requestBody).pipe(
      catchError((error: any) => {
        console.error('Error:', error);
        throw error;  // Rethrow the error to propagate it to the component
      })
    );;
  }
}
