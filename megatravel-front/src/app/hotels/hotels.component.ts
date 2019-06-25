import { Component, OnInit, Input } from '@angular/core';
import { Hotel } from '../_model/hotel';
import { HotelServiceService } from '../_services/hotel.service';
import { Filter } from '../_model/filter';
import { Data } from '@angular/router';

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

  types:[]

  services: string[] = [];

  constructor(private hotelService: HotelServiceService) { }

  ngOnInit() {
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
