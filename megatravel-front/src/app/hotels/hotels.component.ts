import { Component, OnInit } from '@angular/core';
import { Hotel } from '../model/hotel';
import { HotelServiceService } from '../services/hotel.service';

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.sass']
})
export class HotelsComponent implements OnInit {

  hotels: Hotel[] = [];

  constructor(private hotelService: HotelServiceService) { }

  ngOnInit() {
    this.getAllHotels();
  }

  public getAllHotels(){
    this.hotelService.getAllHotels().subscribe(
      res => {
        this.hotels = res;
      },
      err => {
        alert("An error has occured while getting all hotels")
      }
    )
  }

}
