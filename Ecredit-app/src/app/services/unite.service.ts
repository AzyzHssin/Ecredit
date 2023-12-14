
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Unite } from '../Models/Unite_Model';
@Injectable({
  providedIn: 'root'
})
export class UniteService {
  constructor(private http:HttpClient) { }
  getUnite(): Observable<any> {
    return this.http.get("http://localhost:9092/api/Unite");
  }
  addUnite(data:Unite){
    this.http.post("http://localhost:9092/api/Unite/add",data);
  }
}
