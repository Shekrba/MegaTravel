import { Component, OnInit } from '@angular/core';
import { LoginService } from './services/login.service';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'agent-ui';
  
  private showNavBar : BehaviorSubject<boolean>;

  constructor(private loginService: LoginService, private router: Router) {
    
  }

  ngOnInit() {
    
    
  }

  
  

}
