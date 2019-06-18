import { Component, OnInit } from '@angular/core';
import { Hotel } from '../_model/hotel';
import { HotelServiceService } from '../_services/hotel.service';
import { ActivatedRoute } from '@angular/router'

@Component({
  selector: 'app-hotel-profile',
  templateUrl: './hotel-profile.component.html',
  styleUrls: ['./hotel-profile.component.sass']
})
export class HotelProfileComponent implements OnInit {

  hotel: Hotel;
  increment = 0;

  constructor(private hotelService: HotelServiceService, private ar: ActivatedRoute) { }

  ngOnInit() {
    this.getOneHotel();
  }

  public getOneHotel(){

    let id;

    this.ar.paramMap.subscribe(
      params => {
        id = params.get('id');
      }
    )

    this.hotelService.getOneHotel(id).subscribe(
      res => {
        this.hotel = res;        
      },
      err => {
        alert("An error has occured while getting hotel " + id);
      }
    )
  }

}
