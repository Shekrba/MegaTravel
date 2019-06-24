import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';
import { AccomodationService } from '../../services/accomodation.service';
import { LoginService } from '../../services/login.service';

import { AccomodationUnit } from '../../model/AccomodationUnit';

@Component({
  selector: 'app-edit-accomodation-unit',
  templateUrl: './edit-accomodation-unit.component.html',
  styleUrls: ['./edit-accomodation-unit.component.css']
})
export class EditAccomodationUnitComponent implements OnInit {

  idAccomodationUnit : number;
  idAccomodation : number;
  accomodationUnit : AccomodationUnit = new AccomodationUnit();

  constructor( 
    private loginService : LoginService, 
    private accomodationService: AccomodationService,
    private router : Router,
    private route: ActivatedRoute) {
      this.idAccomodationUnit = parseInt(this.route.snapshot.paramMap.get("idUnit"));
      this.idAccomodation = parseInt(this.route.snapshot.paramMap.get("idAccomodation"));
      this.accomodationService.getAccomodationUnit(this.idAccomodationUnit).subscribe( data => this.accomodationUnit = data )
      
    }

  ngOnInit() {
   
  }

  cancel() : void {
    this.loginService.setShowMenu(true);
    this.router.navigate(['/accomodationUnits', this.idAccomodation]);
  }

  update() : void {
    this.accomodationService.updateAccomodationUnit(this.accomodationUnit,this.idAccomodation).subscribe(
      response => {
        window.alert('Uspesan update!');
        this.loginService.setShowMenu(true);
        this.router.navigate(['/accomodationUnits', this.idAccomodation]);
      },
      error => {
        window.alert('Neuspesan update!');
      }
    );
  }



}
