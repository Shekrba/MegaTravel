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
    id:null,
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
        
        this.user = res;

        if(this.user.id==null){
          this.toastr.warning("Username is already taken.");
        }
        else{
          this.toastr.success("Registration successful.", "Registration");
          this.router.navigate(['']);
        }
      },
      err => {
        
        this.toastr.error("Username already exists.", "Registration");
      }
    );
  }

}
