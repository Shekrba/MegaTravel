import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel } from '../model/hotel'
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HotelServiceService {

  private ALL_HOTELS_URL = "http://localhost:8762/search-service/api/hotels"

  constructor(private http: HttpClient) { }

  getAllHotels(): Observable<Hotel[]>{

    return this.http.get<Hotel[]>(this.ALL_HOTELS_URL);
  }
}
