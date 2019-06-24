import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';
import { AccomodationService } from '../../services/accomodation.service';

import { Reservation } from '../../model/Reservation'; 

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit {

  idAccomodationUnit : number;
  idAccomodation : number;
  reservations : Array<Reservation> = [];

  constructor(
    private accomodationService: AccomodationService,
    private router : Router,
    private route: ActivatedRoute
  ) { 
    this.idAccomodation = parseInt(this.route.snapshot.paramMap.get("idAccomodation"));
    this.idAccomodationUnit = parseInt(this.route.snapshot.paramMap.get("idUnit"));
    this.accomodationService.getReservations(this.idAccomodationUnit).subscribe(
      data => {this.reservations = data; console.log(data)}
    );
  }

  ngOnInit() {
  }

  confirm(idReservation: number) : void {
    this.accomodationService.confirmReservation(idReservation).subscribe(
      response => {
        window.alert('Rezervacija je potvrdjena!');
        this.router.navigate(['/accomodationUnits',this.idAccomodation]);
      }
    );
  }

  decline(idReservation: number) : void {
    this.accomodationService.declineReservation(idReservation).subscribe(
      response => {
        window.alert('Rezervacija je otkaza!');
        this.router.navigate(['/accomodationUnits',this.idAccomodation]);
      }
    );
  }

}
