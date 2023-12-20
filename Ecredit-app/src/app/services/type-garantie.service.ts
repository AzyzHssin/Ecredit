import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { TypeGuarantie } from '../Models/TypeGuarantie_Model';
@Injectable({
  providedIn: 'root'
})
export class TypeGarantieService {

  constructor(private http:HttpClient) { }
  getTypeGarantie(): Observable<TypeGuarantie[]> {
    return this.http.get<TypeGuarantie[]>("http://localhost:9092/api/TypeGuarantie");
  }
}
