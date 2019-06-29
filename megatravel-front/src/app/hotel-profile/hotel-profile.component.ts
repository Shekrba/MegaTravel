import { Component, OnInit } from '@angular/core';
import { Hotel } from '../_model/hotel';
import { HotelServiceService } from '../_services/hotel.service';
import { ActivatedRoute, Router, Data } from '@angular/router'
import { HotelsComponent } from '../hotels/hotels.component';
import { AuthenticationService } from '../_services/authentication.service';
import { ToastrService } from 'ngx-toastr';

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

  komentari : Data = []

  minDate = new Date();

  constructor(private hotelService: HotelServiceService, private toastr: ToastrService, private ar: ActivatedRoute, private router: Router, private authService: AuthenticationService) { }

  ngOnInit() {
    
    this.minDate.setHours(0,0,0,0);
    
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

    if((new Date(this.from)) < this.minDate && this.from != null){
      this.toastr.error("From Date can't be lower than Today");
      return;
    }

    if(new Date(this.to)<new Date(this.from)){
      this.toastr.error("To Date can't be lower than From Date");
      return;
    }

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
        
        this.getComments(id);

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

  getComments(id){
    this.hotelService.getAllComments(id).subscribe(
      res => {

        for(let i=0; i<res.length; i++){
          let ocena = res[i];
          
          this.hotelService.getUsername(ocena.korisnik_id).subscribe(
            res => {
              let u = res;
                
              let kom = {
                text : ocena.komentar,
                id : ocena.ocena_id,
                username : u,
                vrednost: ocena.vrednost
                }
        
                this.komentari.push(kom);           
            },
            err => {
              alert("An error has occured while getting a username.");
            }
          )
        }
      },
      err => {
        alert("An error has occured while getting all comments.");
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
