import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { BankAccount } from '../Models/BankAccount_Model';
@Injectable({
  providedIn: 'root'
})
export class BankaccountService {
  constructor(private http:HttpClient) { }
  getBankAccounts(): Observable<BankAccount[]> {
    return this.http.get<BankAccount[]>("http://localhost:9092/api/BankAccount");
  }
  getBankAccountByCustomer(id:number):Observable<BankAccount[]>{
    console.log("executed route to backend: http://localhost:9092/api/BankAccount/ByCustomer/{id}")
    return this.http.get<BankAccount[]>(`http://localhost:9092/api/BankAccount/ByCustomer/${id}`)
  }
}
//http://localhost:8090/ port el dar
// port el khedma 9092
