import { Component, OnInit } from '@angular/core';
import { HotelServiceService } from '../_services/hotel.service';
import { ActivatedRoute, Data } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { AuthenticationService } from '../_services/authentication.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.sass']
})
export class ReservationComponent implements OnInit {

  hotel : Data = {}

  body: Data = {
    from : null,
    to : null,
    hotelId : null,
    roomId : null
  }

  services = []

  constructor(private hotelService: HotelServiceService, private ar: ActivatedRoute,private toastr: ToastrService,private router: Router,private authService:AuthenticationService) { }

  ngOnInit() {

    this.body.from = this.hotelService.from;
    this.body.to = this.hotelService.to;
    this.body.hotelId = this.hotelService.hotelId;
    this.body.roomId = this.hotelService.roomId;

    console.log(this.hotelService.from);
    console.log(this.hotelService.to);
    console.log(this.hotelService.hotelId);
    console.log(this.hotelService.roomId);
    

    this.hotelService.formReservation(this.body).subscribe(
      res => {
        this.hotel = res;        
      },
      err => {
        alert("An error has occured while getting hotel");
      }
    );
  }

  checkService(ev, data) {

    if(ev.target.checked){
      this.services.push(data);
      this.hotel.cost += data.cena;
    }else {
      let removeIndex = this.services.indexOf(data);

      if(removeIndex > -1){
        this.services.splice(removeIndex,1);
        this.hotel.cost -= data.cena;
      }
    }
  }

  makeReservaton(){

    let reservation = {
      from : this.body.from,
      to : this.body.to,
      cost : this.hotel.cost,
      korisnikId : this.authService.currentUserValue.id,
      sjedinicaId : this.body.roomId,
      services : this.services
    }

    this.hotelService.makeReservation(reservation).subscribe(
      res => {
        this.toastr.success("Reservation was made.", "Booking");
        
        this.hotelService.from = null;
        this.hotelService.to = null;
        this.hotelService.hotelId = null;
        this.hotelService.roomId = null;

        this.router.navigate(['/']);  
      },
      err => {
        alert("An error has occured while making a reservation");
      }
    );
  }

}
