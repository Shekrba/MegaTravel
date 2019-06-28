import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";

import { AccomodationService } from '../../services/accomodation.service';
import { LoginService } from '../../services/login.service';


@Component({
  selector: 'app-accomodation-images',
  templateUrl: './accomodation-images.component.html',
  styleUrls: ['./accomodation-images.component.css']
})
export class AccomodationImagesComponent implements OnInit {

  idAccomodation : number;
  sources : Array<any> = [];
  src : string = '';
  images : Array<any> = [];

  constructor(
      private route : ActivatedRoute,
      private accomodationService: AccomodationService,
      private router : Router,
      private loginService : LoginService,
  ) {
    this.idAccomodation = parseInt(this.route.snapshot.paramMap.get("id"));
    this.accomodationService.getImages(this.idAccomodation).subscribe(
     data => {
      this.sources = data;
      let imgs = [];
      this.sources.forEach(el => imgs.push(`data:image/jpeg;base64,${el}`));
      this.images = imgs;
     }
    );
  }

  ngOnInit() {
    
  }

}
