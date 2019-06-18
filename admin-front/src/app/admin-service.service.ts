import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  private ALL_SERVICES_URL = "http://localhost:8762/admin-service/api/admin/services";

  constructor( private http: HttpClient) { }

  getAllServices(): Observable<string[]>{

    return this.http.get<string[]>(this.ALL_SERVICES_URL);
  }
}
