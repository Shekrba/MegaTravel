import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from './_services/authentication.service';
import { Router } from '@angular/router';
import { AdminServiceService } from './admin-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  title = 'admin-front';

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    private adminService:AdminServiceService
  ) { 
  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']);
  }
}
