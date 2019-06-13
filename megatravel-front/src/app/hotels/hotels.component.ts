import { Component, OnInit } from '@angular/core';
import { Hotel } from '../model/hotel';
import { HotelServiceService } from '../services/hotel.service';
import { Filter } from '../model/filter';
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
  services: string[] = [];

  constructor(private hotelService: HotelServiceService) { }

  ngOnInit() {
    this.getAllHotels();
    this.getAllServices();
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
