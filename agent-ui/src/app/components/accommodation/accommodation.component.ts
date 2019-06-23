import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccomodationService } from '../../services/accomodation.service';
import { LoginService } from '../../services/login.service';

import { Accomodation } from '../../model/Accomodation';

@Component({
  selector: 'app-accommodation',
  templateUrl: './accommodation.component.html',
  styleUrls: ['./accommodation.component.css']
})
export class AccommodationComponent implements OnInit {

  options : Array<any>;
  showCancelTime : boolean = false;
  source : string = "";
  images : Array<any> = [];
  wayForIncome : string ='';

  accomodation : Accomodation = new Accomodation();


  typesOfAccomodation : Array<any> = [];
  servicesOfAccomodation : Array<any> = [];

  constructor(private loginService : LoginService, 
    private accomodationService: AccomodationService,
    private router : Router) { 
      this.accomodationService.getAccomodationTypes().subscribe(data => this.typesOfAccomodation = data);
      this.accomodationService.getServices().subscribe(data => {this.servicesOfAccomodation = data; console.log(data) });
    }

  ngOnInit() {
  }
  
  

  projectImage(file: File) : void{ 
    let reader = new FileReader;
    // TODO: Define type of 'e'
    reader.onload = (e: any) => {
        // Simply set e.target.result as our <img> src in the layout
        this.source = e.target.result;
        this.images.push(e.target.result);
    };
    // This will process our file and get it's attributes/data
    reader.readAsDataURL(file);
  } 

  updateSource($event: Event) : void {
    // We access he file with $event.target['files'][0]
    this.projectImage($event.target['files'][0]);
  }

  removeImage(id : number) : void {
    this.images.splice(id , 1);
  }

  add() : void {
    this.accomodationService.addAcomodation(this.accomodation).subscribe(response => {
      window.alert('Smestaj uspesno dodat!');
      this.router.navigate(['/accomodations'])},
      error => window.alert("Neuspesno dodavanje smestaja!")
    );
  }
 

}
