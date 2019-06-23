import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService : LoginService, private router: Router) { }

  ngOnInit() {
    this.loginService.setShowMenu(false);
  }

  login() : void {
    this.loginService.setShowMenu(true);
    this.router.navigate(['/accomodations']);
  }

}
