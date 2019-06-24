import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { AccomodationService } from '../../services/accomodation.service';


import { Accomodation } from '../../model/Accomodation';


@Component({
  selector: 'app-accomodations',
  templateUrl: './accomodations.component.html',
  styleUrls: ['./accomodations.component.css']
})
export class AccomodationsComponent implements OnInit {

  private accomodations : Accomodation[] = [];

  constructor(private loginService : LoginService, 
    private accomodationService: AccomodationService,
    private router : Router
    ) {
    this.accomodationService.getAccomodations().subscribe(data => { this.accomodations = data; console.log(data) });
  }

  ngOnInit() {
   
  }

  newAccomodation() : void {
    this.loginService.setShowMenu(false);
    this.router.navigate(['/accomodation']);
  }

  rooms(id : number) : void {
    this.router.navigate(['/accomodationUnits',  id ]);
  }

  edit(id : number): void {
    this.loginService.setShowMenu(false);
    this.router.navigate(['/editAccomodation', id]);
  }
  
}
