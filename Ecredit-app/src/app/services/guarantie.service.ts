import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Guarantie } from '../Models/Guarantie_Model';
@Injectable({
  providedIn: 'root'
})
export class GuarantieService {

  private baseUrl = 'http://localhost:9092/api/Guarantie';

  constructor(private http: HttpClient) { }

  addGuarantie(data: Guarantie): Observable<any> {
    return this.http.post(`${this.baseUrl}/add`, data);
  }

  updateGarantie(data: Guarantie): Observable<any> {
    return this.http.put(`${this.baseUrl}/update`, data);
  }

  deleteGuarantie(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
