import { Component, OnInit } from '@angular/core';
import { Hotel } from '../_model/hotel';
import { HotelServiceService } from '../_services/hotel.service';
import { ActivatedRoute, Router } from '@angular/router'
import { HotelsComponent } from '../hotels/hotels.component';
import { AuthenticationService } from '../_services/authentication.service';

@Component({
  selector: 'app-hotel-profile',
  templateUrl: './hotel-profile.component.html',
  styleUrls: ['./hotel-profile.component.sass']
})
export class HotelProfileComponent implements OnInit {

  hotel: Hotel;
  increment = 0;

  from:string = null;
  to:string = null;

  dateFrom:string = null;
  dateTo = null;

  book:boolean = false;

  constructor(private hotelService: HotelServiceService, private ar: ActivatedRoute, private router: Router, private authService: AuthenticationService) { }

  ngOnInit() {
    this.getOneHotel();

    this.from = this.hotelService.from;
    this.to = this.hotelService.to;

    if(this.from != null && this.to != null){
      this.book = true;
      this.dateFrom = this.from;
      this.dateTo = this.to;
    }
  }

  public Book(hotelId,roomId){

    if(this.authService.currentUserValue == null){
      this.router.navigate(['/login']);
      return;
    }

    this.hotelService.hotelId = hotelId;
    this.hotelService.roomId = roomId;
    this.hotelService.from = this.dateFrom;
    this.hotelService.to = this.dateTo;

    this.router.navigate(['/reservation']);  
  }

  public applyButton(){

    let id;

    this.ar.paramMap.subscribe(
      params => {
        id = params.get('id');
      }
    );
    
    if(this.from != null && this.to != null){
      this.book = true;
    }

    this.dateFrom = this.from;
    this.dateTo = this.to;

    this.getFilteredRooms(id);
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

        console.log(this.dateFrom);
        
        if(this.dateFrom != null && this.dateTo != null){
          this.getFilteredRooms(id);
        }
      },
      err => {
        alert("An error has occured while getting hotel " + id);
      }
    )
  }

  getFilteredRooms(id){
    this.hotelService.getFilteredRooms(id,this.dateFrom,this.dateTo).subscribe(
      res => {
        this.hotel.sjedinice = res;        
      },
      err => {
        alert("An error has occured while getting rooms of hotel " + id);
      }
    )
  }

}
