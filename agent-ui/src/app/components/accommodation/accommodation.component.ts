import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccomodationService } from '../../services/accomodation.service';
import { LoginService } from '../../services/login.service';

import { Accomodation } from '../../model/Accomodation';
import { Picture } from '../../model/Picture';
import { VirtualTimeScheduler } from 'rxjs';

@Component({
  selector: 'app-accommodation',
  templateUrl: './accommodation.component.html',
  styleUrls: ['./accommodation.component.css']
})
export class AccommodationComponent implements OnInit {

  options : Array<any>;
  showCancelTime : boolean = false;
  source : string = "";
  images : Array<Picture> = [];
  wayForIncome : string ='';
  id: number = 1;
  showImageList : boolean = false;
  btnText : string = 'Show image List';
  showImage : boolean = true;

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
    const { id } = this;
    // TODO: Define type of 'e'
    reader.onload = (e: any) => {
        // Simply set e.target.result as our <img> src in the layout
        this.source = e.target.result;
        let picture = new Picture();
        picture.id = id;
        picture.data = file;
        this.images.push(picture);
        this.id = id + 1;
    };
    // This will process our file and get it's attributes/data
    reader.readAsDataURL(file);
  } 

  updateSource($event: Event) : void {
    // We access he file with $event.target['files'][0]
    console.log($event.target['files'][0]);
    this.projectImage($event.target['files'][0]);
  }

  project(file: File) : void {
    let reader = new FileReader;
    reader.onload = (e: any) => {
      this.source = e.target.result;
    }
    reader.readAsDataURL(file);
  }

  add() : void {
    this.accomodationService.addAcomodation(this.accomodation).subscribe(response => {
      window.alert('Smestaj uspesno dodat!');
      this.accomodationService.uploadImages(this.images, response.id).subscribe(
        data => this.router.navigate(['/accomodations'])
      )
    },
      error => window.alert("Neuspesno dodavanje smestaja!")
    );
  }

  showListImg() : void {
    const { showImageList } = this;
    this.showImageList = !showImageList;
    if(showImageList)
    {
      this.btnText = 'Show image List';
      return;
    }
    this.btnText = 'Hide image List'
    
  }

  show(id: number): void {
    const imgSrc = this.images.find((o) => o.id === id);
    this.project(imgSrc.data)
  }

  remove(id :number): void {
    const image  = this.images.find(o => o.id === id);
    if(image.data === this.source)
      this.source = '';
    this.images = this.images.filter(o => o.id !== id)
  }
 

}
