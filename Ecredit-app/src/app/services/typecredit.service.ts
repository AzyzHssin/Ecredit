
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { TypeCredit } from '../Models/TypeCredit_Model';
@Injectable({
  providedIn: 'root'
})
export class TypecreditService {
  constructor(private http:HttpClient) { }
  getTypeCredit(): Observable<any> {
    return this.http.get("http://localhost:8090/api/TypeCredit");
  }
  addTypeCredit(data:TypeCredit){
    this.http.post("http://localhost:8090/api/TypeCredit/add",data);
  }
}
