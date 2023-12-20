import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Guarantie } from '../Models/Guarantie_Model';
@Injectable({
  providedIn: 'root'
})
export class GuarantieService {

  constructor(private http:HttpClient) { }

  addGuarantie(data:Guarantie){
   return this.http.post("http://localhost:9092/api/Guarantie/add",data);
  }
}
