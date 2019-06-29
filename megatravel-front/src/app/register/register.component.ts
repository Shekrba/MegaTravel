import { Component, OnInit } from '@angular/core';
import { HotelServiceService } from '../_services/hotel.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.sass']
})
export class RegisterComponent implements OnInit {

  user ={
    ime:null,
    prezime:null,
    email:null,
    username:null,
    password:null
  }

  constructor(private hotelService:HotelServiceService,private toastr: ToastrService, private router: Router) { }

  ngOnInit() {
  }

  public register(){
    this.hotelService.register(this.user).subscribe(
      res => {
        console.log(res);
        
        this.toastr.success("Registration successful.", "Registration");
        this.router.navigate(['']);
      },
      err => {
        console.log(err);
        
        this.toastr.error("Username already exists.", "Registration");
      }
    );
  }

}
