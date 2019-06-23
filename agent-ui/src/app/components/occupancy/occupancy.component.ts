import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router } from "@angular/router";

import { AccomodationService } from '../../services/accomodation.service';
import { LoginService } from '../../services/login.service';
import { Accomodation } from '../../model/Accomodation';
import { Occupancy } from '../../model/Occupancy';

@Component({
  selector: 'app-occupancy',
  templateUrl: './occupancy.component.html',
  styleUrls: ['./occupancy.component.css']
})
export class OccupancyComponent implements OnInit {

  idAccomodation: number;
  idAccomodationUnit : number;
  occupancy: Occupancy = new Occupancy();
  accomodation : Accomodation = new Accomodation();

  constructor(
    private route : ActivatedRoute,
    private accomodationService: AccomodationService,
    private router : Router,
    private loginService : LoginService,
  ) { 
    this.idAccomodation = parseInt(this.route.snapshot.paramMap.get("idAccomodation"));
    this.idAccomodationUnit = parseInt(this.route.snapshot.paramMap.get("idUnit"));
    this.accomodationService.getAccomodation(this.idAccomodation).subscribe(
      response => this.accomodation = response
    );
    
  }

  cancel() : void {
    this.loginService.setShowMenu(true);
    this.router.navigate(['/accomodationUnits', this.idAccomodation]);
  }

  add() : void {
    this.accomodationService.occupyUnit(this.idAccomodationUnit,this.occupancy).subscribe(
      response => {
        window.alert('Uspesno zauzeta!');
        this.loginService.setShowMenu(true);
        this.router.navigate(['/accomodationUnits', this.idAccomodation]);
      },
      error => window.alert('Greska!')
    );
  }

  ngOnInit() {
  }

}
