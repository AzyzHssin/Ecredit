import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import {NatureGuarantie } from '../Models/NatureGuarantie_Model'
@Injectable({
  providedIn: 'root'
})
export class NatureGarantieService {

  constructor(private http:HttpClient) { }
  getNatureGarantie(): Observable<NatureGuarantie[]> {
    return this.http.get<NatureGuarantie[]>("http://localhost:9092/api/NatureGuarantie");
  }
}
