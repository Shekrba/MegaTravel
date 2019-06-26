import { Injectable, KeyValueDiffers } from '@angular/core';
import { Observable, from } from 'rxjs';
import { Hotel } from '../_model/hotel'
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ɵCssKeyframesDriver } from '@angular/animations/browser';

@Injectable({
  providedIn: 'root'
})
export class HotelServiceService {

  private ALL_HOTELS_URL = "http://localhost:8762/search-service/api/hotels"
  private ALL_ROOMS_URL = "http://localhost:8762/search-service/api/rooms"
  private ALL_SERVICES_URL = "http://localhost:8762/search-service/api/services"
  private ALL_TYPES_URL = "http://localhost:8762/search-service/api/types"
  private GOOGLE_CLOUD = "https://us-central1-megatravel-244015.cloudfunctions.net"
  private ALL_RESERVATIONS_URL = "http://localhost:8762/reservation-service/api/reservations"

  from : string = null;
  to: string = null;
  hotelId = null;
  roomId = null;

  constructor(private http: HttpClient) { }

  getAllHotels(): Observable<Hotel[]>{

    return this.http.get<Hotel[]>(this.ALL_HOTELS_URL);
  }

  getAllServices(): Observable<string[]>{

    return this.http.get<string[]>(this.ALL_SERVICES_URL);
  }

  getOneHotel(id): Observable<Hotel> {

    return this.http.get<Hotel>(this.ALL_HOTELS_URL + "/" + id);
  }

  getFilteredRooms(id,dateFrom,dateTo): Observable<any>{
    
    return this.http.post<Hotel>(this.ALL_ROOMS_URL + "/" + id,{dateFrom:dateFrom,dateTo:dateTo}, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

  formReservation(form): Observable<any>{
    
    return this.http.post<Hotel>(this.ALL_RESERVATIONS_URL + "/form",form, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

  filterHotels(filter): Observable<Hotel[]> {
    return this.http.post<Hotel[]>(this.ALL_HOTELS_URL,filter, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

  makeReservation(body): Observable<any> {
    return this.http.post(this.ALL_RESERVATIONS_URL,body, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
      responseType : 'text'
    });
  }

  getTypes(): Observable<any> {
    return this.http.get(this.ALL_TYPES_URL);
  }

  getRezToRate(id): Observable<any> {
    return this.http.get(this.ALL_RESERVATIONS_URL+"/rate/"+id);
  }

  getCloudData(id): Observable<any> {
    
    return this.http.post(this.GOOGLE_CLOUD+"/getRatings",{korisnik_id : id}, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
    })
  }

  rate(v,rid,kom,kid,sid,from,to): Observable<any> {
  
    let body = {
      vrednost:parseInt(v),
      rezervacija_id : rid,
      komentar : kom,
      korisnik_id : kid,
      smestaj_id : sid,
      from : from,
      to : to
    };
    
    console.log(body);

    return this.http.post(this.GOOGLE_CLOUD+"/rateHotel",body, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
      responseType : 'text'
    });
  }

  setRatedTrue(id): Observable<any>{
    return this.http.put(this.ALL_RESERVATIONS_URL+"/rate/"+id, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
      responseType : 'text'
    });
  }

  updateRating(v,kom,oid): Observable<any> {
    let body = {
      vrednost:parseInt(v),
      ocena_id : oid,
      komentar : kom
    }

    return this.http.post(this.GOOGLE_CLOUD+"/updateRating",body, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
      responseType : 'text'
    });
  }


}
