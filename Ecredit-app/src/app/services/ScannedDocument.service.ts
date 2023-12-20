import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SacannedDocumentService {
  private apiUrl = 'http://localhost:9092/pdf';

  constructor(private http: HttpClient) {}

  public uploadPdf(file: File): Observable<number> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/pdf' });
    const formData: FormData = new FormData();
    formData.append('pdf', file);
    return this.http.post<number>(`${this.apiUrl}/add`, formData);
  }
  downloadPdf(fileId: number): Observable<Blob> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/pdf' });

    return this.http.get(`${this.apiUrl}/get/${fileId}`, {
      headers: headers,
      responseType: 'blob'
    });
  }


}
