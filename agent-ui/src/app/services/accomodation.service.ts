import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Accomodation } from '../model/Accomodation';
import { AccomodationUnit } from '../model/AccomodationUnit';
import { Occupancy } from '../model/Occupancy';
import { Message } from '../model/Message';
import { Picture } from '../model/Picture';
import { Cenovnik } from '../model/Cenovnik';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


const ROOT_URL = 'http://localhost:8082/api';

@Injectable({
  providedIn: 'root'
})
export class AccomodationService {

  constructor(private http: HttpClient) { }

  getAccomodations() : Observable<any> {
    return this.http.get(`${ROOT_URL}/accomodations`);
  }

  getServices() : Observable<any> {
    return this.http.get(`${ROOT_URL}/services`);
  }

  getAccomodationUnits(id: any) : Observable<any> {
    return this.http.get(`${ROOT_URL}/accomodationUnits/${id}`);
  }

  getAccomodationTypes() : Observable<any> {
    return this.http.get(`${ROOT_URL}/types`);
  }

  getAccomodation(id : any) : Observable<any>{
    return this.http.get(`${ROOT_URL}/hoteli/${id}`);
  } 

  getAccomodationUnit(id : any) : Observable<any>{
    return this.http.get(`${ROOT_URL}/accomodationUnit/${id}`);
  } 

  addAcomodation(body: Accomodation): Observable<any> {
    return this.http.post(`${ROOT_URL}/smestajAdd`, body);
  }

  uploadImages(images: Array<Picture>, id : number): Observable<any> {
    let formData = new FormData();
    for(let i = 0; i < images.length; i++)
    {
      formData.append("images", images[i].data);
    }
    console.log(formData.getAll("images"))
    return this.http.post(`${ROOT_URL}/upload/${id}`, formData);
  }

  updateAccomodation(body: Accomodation): Observable<any> {
    return this.http.put(`${ROOT_URL}/smestajUpdate`,body, httpOptions)
  }

  addAccomodationUnit(body: AccomodationUnit, id: number): Observable<any> {
    return this.http.post(`${ROOT_URL}/accomodationUnit/${id}`, body, httpOptions);
  }

  updateAccomodationUnit(body: AccomodationUnit, id: number): Observable<any> {
    return this.http.put(`${ROOT_URL}/accomodationUnit/${id}`, body, httpOptions);
  }

  getReservations(idAccUnit: number): Observable<any> {
    return this.http.get(`${ROOT_URL}/reservations/${idAccUnit}`);
  }

  confirmReservation(idReservation : number): Observable<any> {
    return this.http.put(`${ROOT_URL}/confirmReservation/${idReservation}`,{idReservation}, httpOptions);
  }

  declineReservation(idReservation : number): Observable<any> {
    return this.http.put(`${ROOT_URL}/declineReservation/${idReservation}`,{idReservation}, httpOptions);
  }

  occupyUnit(idAccUnit: number, body: Occupancy): Observable<any> {
    return this.http.post(`${ROOT_URL}/occupancy/${idAccUnit}`, body, httpOptions);
  }

  getMessages(): Observable<any> {
    return this.http.get(`${ROOT_URL}/messages`);
  }

  getMessage(id:number): Observable<any> {
    return this.http.get(`${ROOT_URL}/message/${id}`);
  }

  answerMessage(id:number, body: Message) : Observable<any> {
    return this.http.post(`${ROOT_URL}/answerMessage/${id}`, body, httpOptions);
  }

  getImages( id:number ) : Observable<any> {
    return this.http.get(`${ROOT_URL}/images/${id}`);  
  }

  setCenovnik(id:number, body: Cenovnik) : Observable<any> {
    return this.http.post(`${ROOT_URL}/pricelist/${id}`,body);
  }

  


  
}
