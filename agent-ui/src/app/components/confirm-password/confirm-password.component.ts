import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";

import { AccomodationService } from '../../services/accomodation.service';
import { LoginService } from '../../services/login.service';  
import { User } from 'src/app/model/User';

@Component({
  selector: 'app-confirm-password',
  templateUrl: './confirm-password.component.html',
  styleUrls: ['./confirm-password.component.css']
})
export class ConfirmPasswordComponent implements OnInit {

  username : string = '';
  showError : boolean = false;
  password : string = '';
  repeatPassword : string = '';

  constructor(
    private route : ActivatedRoute,
    private accomodationService: AccomodationService,
    private router : Router,
    private loginservice : LoginService
  ) { 
    this.username = this.route.snapshot.paramMap.get("username");

  }

  ngOnInit() {
  }

  confirm() : void {
    const {
      password,
       repeatPassword,
       username
    } = this;

    if(password === repeatPassword)
    {
     
      let user : User = new User();
      user.username = this.username;
      user.password = this.password;
      console.log(user);
      this.loginservice.confirmPassword(user).subscribe(
        response => {
          this.loginservice.setShowMenu(true);
          this.cancel();
        }
      );
    }
    else
    {
      this.showError = true;
    }

  }

  cancel() : void {
    this.loginservice.logout();
    this.router.navigate(['/login']);
  }


}
