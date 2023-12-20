import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { PieceJointe } from '../Models/PieceJointe_Model';
@Injectable({
  providedIn: 'root'
})
export class PiecesjointesService {

  constructor(private http:HttpClient) { }
  getPiecesJointesByTypeCredit(id:number): Observable<PieceJointe[]>{
    return this.http.get<PieceJointe[]>(`http://localhost:8090/api/PieceJointe/ByTypeCredit/${id}`);
  }
  getPiecesJointes(): Observable<PieceJointe[]>{
    return this.http.get<PieceJointe[]>(`http://localhost:8090/api/PieceJointe`);
  }
}
