import { Component, OnInit, Input } from '@angular/core';
import { Hotel } from '../_model/hotel';
import { HotelServiceService } from '../_services/hotel.service';
import { Filter } from '../_model/filter';
import { Data } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.sass']
})
export class HotelsComponent implements OnInit {

  hotels: Hotel[] = [];
  filter: Data = {
    mesto : "",
    brojKreveta : null,
    dateFrom : null,
    dateTo : null,
    tip : "ALL",
    kategorija: "ALL",
    usluge: []
  };

  minDate = new Date();

  types:[]

  services: string[] = [];

  constructor(public _DomSanitizer: DomSanitizer,private hotelService: HotelServiceService, private toastr: ToastrService) { }

  ngOnInit() {
    this.minDate.setHours(0,0,0,0);

    this.getAllHotels();
    this.getAllServices();
    this.getAllTypes();
  }

  public getAllTypes(){
    this.hotelService.getTypes().subscribe(
      res => {
        this.types = res;
      },
      err => {
        alert("An error has occured while getting all types")
      }
    )
  }

  public getAllHotels(){
    this.hotelService.getAllHotels().subscribe(
      res => {
        this.hotels = res;
        console.log(this.hotels[0].slike);
      },
      err => {
        alert("An error has occured while getting all hotels")
      }
    )
  }

  public getAllServices(){
    this.hotelService.getAllServices().subscribe(
      res => {
        this.services = res;
      },
      err => {
        alert("An error has occured while getting all services");
      }
    )
  }

  public filterHotels(){
    if((new Date(this.filter.dateFrom)) < this.minDate && this.filter.dateFrom != null){      
      this.toastr.error("From Date can't be lower than Today");
      return;
    }

    if(new Date(this.filter.dateTo)<new Date(this.filter.dateFrom)){
      this.toastr.error("To Date can't be lower than From Date");
      return;
    }

    this.hotelService.filterHotels(this.filter).subscribe(
      res => {
        this.hotels = res;
        this.hotelService.from = this.filter.dateFrom;
        this.hotelService.to = this.filter.dateTo;
      },
      err => {
        alert("An error has occured while filtering hotels")
      }
    )
  }

  checkService(ev, data) {

    if(ev.target.checked){
      this.filter.usluge.push(data);

    }else {
      let removeIndex = this.filter.usluge.indexOf(data);

      if(removeIndex > -1)
        this.filter.usluge.splice(removeIndex,1);
    }

    console.log(this.filter.usluge);
  }

}
