import { Component, OnInit } from '@angular/core';
import { User } from '../_model/user';
import { Router } from '@angular/router';
import { AuthenticationService } from '../_services/authentication.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.sass']
})
export class NavComponent implements OnInit {

  currentUser$: Observable<User>;

  constructor(
      private router: Router,
      private authenticationService: AuthenticationService
  ) {
      this.currentUser$=this.authenticationService.currentUser;
  }

  ngOnInit(): void {
  }

  logout() {
      this.authenticationService.logout();
      this.router.navigate(['/login']);
  }

}
