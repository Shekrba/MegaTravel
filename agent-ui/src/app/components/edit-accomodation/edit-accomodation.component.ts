import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AccomodationService } from '../../services/accomodation.service';
import { LoginService } from '../../services/login.service';

import { Accomodation } from '../../model/Accomodation';

@Component({
  selector: 'app-edit-accomodation',
  templateUrl: './edit-accomodation.component.html',
  styleUrls: ['./edit-accomodation.component.css']
})
export class EditAccomodationComponent implements OnInit {

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
    private router : Router,private route: ActivatedRoute) { 
      this.accomodationService.getAccomodation(this.route.snapshot.paramMap.get("id")).subscribe(data => {this.accomodation = data; console.log(data)});
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

  selected(id:number) : boolean {
    console.log(id);
    console.log(this.accomodation.additionalServices.indexOf(id) !== -1);
    return this.accomodation.additionalServices.indexOf(id) !== -1;
  }

  update() : void {
    const { accomodation } = this;
    this.accomodationService.updateAccomodation(accomodation).subscribe( (response) => {
      window.alert('Smestaj uspesno izmenjen!');
      this.loginService.setShowMenu(true);
      this.router.navigate(['/accomodations']);
    }, 
    error => window.alert('Neuspesan update smestaja!'));
  }

}
