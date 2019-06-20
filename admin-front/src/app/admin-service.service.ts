import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const BASE_URL = "http://localhost:8762/admin-service";

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {


  private ALL_SERVICES_URL = `${BASE_URL}/api/admin/services`;
  private ALL_COMMENTS_URL = `${BASE_URL}/api/admin/comments`;
  private ALL_USERS_URL = `${BASE_URL}/api/admin/user`;
  private ALL_AGENTS_URL = `${BASE_URL}/api/admin/agent`;
  private ALL_TYPES_URL = `${BASE_URL}/api/admin/types`;

  constructor( private http: HttpClient) { }

  getAllServices(): Observable<any>{

    return this.http.get(this.ALL_SERVICES_URL);
  }

  getOneService(id): Observable<any>{

    return this.http.get(this.ALL_SERVICES_URL+"/"+id);
  }

  deleteService(id): Observable<any>{
    return this.http.delete(this.ALL_SERVICES_URL+"/"+id,{responseType: 'text'});
  }

  addService(usl): Observable<any>{
    return this.http.post(this.ALL_SERVICES_URL, usl,{
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }
  
  updateService(usluga): Observable<any>{
    return this.http.put(this.ALL_SERVICES_URL+"/"+usluga.id,usluga,{
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

  getAllComments(): Observable<any>{
    return this.http.get(this.ALL_COMMENTS_URL);
  }

  publishing(k): Observable<any>{
    return this.http.put(this.ALL_COMMENTS_URL+"/"+k.id,k,{
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

  getAllUsers(): Observable<any>{
    return this.http.get(this.ALL_USERS_URL);
  }

  activateUser(u): Observable<any>{
    return this.http.post(this.ALL_USERS_URL+"/"+u.id,u,{
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

  blockUser(u): Observable<any>{
    return this.http.put(this.ALL_USERS_URL+"/"+u.id,u,{
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

  deleteUser(u): Observable<any>{
    return this.http.delete(this.ALL_USERS_URL+"/"+u.id,{
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

  registerAgent(a): Observable<any>{
    return this.http.post(this.ALL_AGENTS_URL,a,{
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

  getAllTypes(): Observable<any>{
    return this.http.get(this.ALL_TYPES_URL);
  }

  addType(t): Observable<any>{
    return this.http.post(this.ALL_TYPES_URL, t,{
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

  deleteType(id): Observable<any>{
    return this.http.delete(this.ALL_TYPES_URL+"/"+id,{responseType: 'text'});
  }

  setServicesForCategory(catId,services): Observable<any>{

    console.log(services);

    return this.http.post(`${BASE_URL}/api/admin/serviceForCategory/`+catId, services,{
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      responseType: 'text'
    });
  }
}