import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel } from '../model/hotel'
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HotelServiceService {

  private ALL_HOTELS_URL = "http://localhost:8762/search-service/api/hotels"
  private ALL_SERVICES_URL = "http://localhost:8762/search-service/api/services"

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

  filterHotels(filter): Observable<Hotel[]> {
    return this.http.post<Hotel[]>(this.ALL_HOTELS_URL,filter, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }
}
