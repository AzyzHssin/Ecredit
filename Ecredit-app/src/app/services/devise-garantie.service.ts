import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Devise } from '../Models/Devise_Model';

@Injectable({
  providedIn: 'root'
})
export class DeviseGarantieService {

  constructor(private http:HttpClient) { }
  getDeviseGarantie(): Observable<Devise[]> {
    return this.http.get<Devise[]>("http://localhost:9092/api/Devise");
  }
}
