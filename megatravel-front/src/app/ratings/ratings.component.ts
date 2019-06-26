import { Component, OnInit } from '@angular/core';
import { HotelServiceService } from '../_services/hotel.service';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from '../_services/authentication.service';

@Component({
  selector: 'app-ratings',
  templateUrl: './ratings.component.html',
  styleUrls: ['./ratings.component.sass']
})
export class RatingsComponent implements OnInit {

  tab : string = 'toRate'

  ratings : [
    {}
  ]

  ratedRatings: [
    {
      smestaj_id:null,
      smestaj_naziv:null,
      rezervacija_id:null
    }
  ]

  toRateRatings : [{
    id: null,
    smestaj_id:null,
    smestaj_naziv:null
  }];

  constructor(private hotelService : HotelServiceService, private toastr: ToastrService, private authService: AuthenticationService) { }

  ngOnInit() {
    this.getRezToRate();
    this.getCloudData();
  }

  getRezToRate(){

    let userId = this.authService.currentUserValue.id

    this.hotelService.getRezToRate(userId).subscribe(
      res => {
        this.toRateRatings = res;
        this.ratings = res;
      },
      err => {
        alert("An error has occured while getting ratings");
      }
    )
  }

  getCloudData(){

    let userId = this.authService.currentUserValue.id

    this.hotelService.getCloudData(userId).subscribe(
      res => {
        this.ratedRatings = res;

        for(let i=0; i < this.ratedRatings.length; i++){
          this.hotelService.getOneHotel(this.ratedRatings[i].smestaj_id).subscribe(
            res => {
              this.ratedRatings[i].smestaj_naziv = res.naziv;        
            },
            err => {
              alert("An error has occured while getting hotel name");
            }
          );
        }
      },
      err => {
        alert("An error has occured while getting ratings");
      }
    )
  }

  toRateButton(){
    this.tab = 'toRate';
    this.ratings = this.toRateRatings;
  }

  ratedButton(){
    this.tab = 'rated';
    this.ratings = this.ratedRatings;
  }

  public rate(r){

    if(r.vrednost == null) {
      this.toastr.warning("Rating value has to be set.", "Rating"); 
      return
    }

    if(r.komentar == null){
      r.komentar = "";
    }

    this.hotelService.setRatedTrue(r.id).subscribe(
      res => {},
      err =>{}
    );

    this.hotelService.rate(r.vrednost,r.id,r.komentar,r.korisnik_id,r.smestaj_id,r.from.split("T")[0],r.to.split("T")[0]).subscribe(
      res => {
        const index = this.toRateRatings.indexOf(r, 0);
        if (index > -1) {
          this.toRateRatings.splice(index, 1);
        }
    
        this.ratings = this.toRateRatings;

        this.getCloudData();
    
        this.toastr.success("Stay is successfully rated.", "Rating");
      },
      err => {
        alert("An error has occured while rating a stay")
      }
    );
  }

  public updateRating(r){

    if(r.vrednost == null) {
      return
    }

    if(r.komentar == null){
      r.komentar = "";
    }

    this.hotelService.updateRating(r.vrednost,r.komentar,r.ocena_id).subscribe(
      res => {
        this.toastr.success("Rating is successfully upated.", "Rating update");  
      },
      err => {
        alert("An error has occured while rating a stay");
      }
    );
  }
}
