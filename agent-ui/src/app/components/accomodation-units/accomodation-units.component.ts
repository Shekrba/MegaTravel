import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";

import { AccomodationService } from '../../services/accomodation.service';
import { LoginService } from '../../services/login.service';
import { AccomodationUnit } from '../../model/AccomodationUnit';
import { Accomodation } from '../../model/Accomodation';

@Component({
  selector: 'app-accomodation-units',
  templateUrl: './accomodation-units.component.html',
  styleUrls: ['./accomodation-units.component.css']
})
export class AccomodationUnitsComponent implements OnInit {
  idAccomodation : number;
  accomodationUnits : Array<AccomodationUnit> = [];
  accomodation : Accomodation;
  filteredAccomodationUnits : Array<AccomodationUnit> = [];

  filterBroj : number = 0;
  filterBrojKreveta : number = 0;
  filterCena : number = 0;

  constructor(private route : ActivatedRoute,
    private accomodationService: AccomodationService,
    private router : Router,
    private loginService : LoginService,
  ){
    
    this.idAccomodation = parseInt(this.route.snapshot.paramMap.get("id"));
    this.accomodationService.getAccomodationUnits(this.idAccomodation).subscribe( 
      data => {
        this.accomodationUnits = data;
        this.filteredAccomodationUnits = data;
    })
    this.accomodationService.getAccomodation(this.idAccomodation).subscribe( data => this.accomodation = data )
  }

  ngOnInit() {
  }

  newAccomodationUnit() : void {
    this.loginService.setShowMenu(false);
    this.router.navigate(['/accomodationUnit', this.idAccomodation]);
  }


  edit(id: number) : void {
    this.loginService.setShowMenu(false);
    this.router.navigate(['/editAccomodationUnit', this.idAccomodation,id])
  }

  reservations(id : number) {
    this.router.navigate(['/reservations', this.idAccomodation, id]);
  }

  occupancy(id :number) {
    this.loginService.setShowMenu(false);
    this.router.navigate(['/occupancy',this.idAccomodation, id]);
  }

  trackByIdentity = (index: number, item: AccomodationUnit): number => item.id;


  filter() : void {
    const {
      filterBroj,
      filterBrojKreveta,
      filterCena,
      accomodationUnits
    } = this;

    

    let filterData = accomodationUnits;

    filterBroj && filterData && filterBroj !== 0 ? filterData = filterData.filter(o => o.broj <= filterBroj) : filterData;
    filterBrojKreveta && filterData && filterBrojKreveta !== 0 ? filterData = filterData.filter(o => o.brojKreveta <= filterBrojKreveta) : filterData
    filterCena && filterData && filterCena !== 0 ? filterData = filterData.filter(o => o.cena <= filterCena) : filterData

    this.filteredAccomodationUnits = filterData;

  }

  cenovnik(id: number) : void {
    this.router.navigate(['/cenovnik',this.idAccomodation,id]);
  }


}
