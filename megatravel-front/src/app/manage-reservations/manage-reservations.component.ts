import { Component, OnInit } from '@angular/core';
import { HotelServiceService } from '../_services/hotel.service';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from '../_services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manage-reservations',
  templateUrl: './manage-reservations.component.html',
  styleUrls: ['./manage-reservations.component.sass']
})
export class ManageReservationsComponent implements OnInit {

  reservations = [];

  constructor(private hotelService : HotelServiceService,private router: Router ,private toastr: ToastrService, private authService: AuthenticationService) { }

  ngOnInit() {
    this.getUserReservations();
  }

  public getUserReservations(){
    let userId = this.authService.currentUserValue.id

    this.hotelService.getUserReservations(userId).subscribe(
      res => {
        this.reservations = res;      
      },
      err => {
        alert("An error has occured while getting reservations");
      }
    );
  }

  public cancelReservation(r){
    this.hotelService.cancelReservation(r.id).subscribe(
      res => {
        const index = this.reservations.indexOf(r, 0);
        if (index > -1) {
          this.reservations.splice(index, 1);
          this.toastr.success(res);
        }      
      },
      err => {
        alert("An error has occured while getting reservations");
      }
    );
  }

  public newMessage(r){
    this.hotelService.agent.id = r.agent_id;
    this.hotelService.agent.username = r.agentUserName;
    this.router.navigate(['/newmessage']);
  }

}
