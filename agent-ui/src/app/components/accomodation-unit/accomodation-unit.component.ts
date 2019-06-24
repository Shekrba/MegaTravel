import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';
import { AccomodationService } from '../../services/accomodation.service';
import { LoginService } from '../../services/login.service';

import { AccomodationUnit } from '../../model/AccomodationUnit';

@Component({
  selector: 'app-accomodation-unit',
  templateUrl: './accomodation-unit.component.html',
  styleUrls: ['./accomodation-unit.component.css']
})
export class AccomodationUnitComponent implements OnInit {

  accomodationUnit : AccomodationUnit = new AccomodationUnit();
  idAccomodation : number;

  constructor(
    private loginService : LoginService, 
    private accomodationService: AccomodationService,
    private router : Router,
    private route: ActivatedRoute) {
      this.idAccomodation = parseInt(this.route.snapshot.paramMap.get("id"));
      
     }

  ngOnInit() {
  }

  cancel() : void {
    this.loginService.setShowMenu(true);
    this.router.navigate(['/accomodationUnits', this.idAccomodation]);
  }

  add() : void {
    this.accomodationService.addAccomodationUnit(this.accomodationUnit, this.idAccomodation).subscribe(
      response => {
        window.alert('Uspesno dodata smestajna jedinica!');
        this.loginService.setShowMenu(true);
        this.router.navigate(['/accomodationUnits', this.idAccomodation]);
      },
      error => window.alert('Neuspesno dodavanje smestajne jedinice!')
    );

  }

}
