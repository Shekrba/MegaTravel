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
  private filterAccomodations : Accomodation[] = [];

  filterName: string = '';
  filterLocation: string = '';
  filterOpis: string = '';

  constructor(private loginService : LoginService, 
    private accomodationService: AccomodationService,
    private router : Router
    ) {
    this.accomodationService.getAccomodations().subscribe(
      data => {
         this.accomodations = data;
         this.filterAccomodations = data; 
      });
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

  trackByIdentity = (index: number, item: Accomodation): number => item.id;
  
  filter() : void {
    const { 
      accomodations,
      filterLocation,
      filterOpis,
      filterName
    } = this;
    let filterData = accomodations;
    
    filterName && filterData? filterData = filterData.filter( o => o.naziv.toLowerCase().includes(filterName.toLowerCase()) )
     : filterData;

    filterLocation && filterData ? filterData = filterData.filter( o => {
      let location = `${o.mesto}, ${o.ulica}, ${o.broj}`;
      return location.toLowerCase().includes(filterLocation.toLowerCase())
    }) : filterData;

    filterOpis && filterData ? filterData = filterData.filter(o => o.opis.toLowerCase().includes(filterOpis.toLowerCase())) : filterData

    this.filterAccomodations = filterData;

  }


}
