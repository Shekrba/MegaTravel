import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { AccomodationService } from '../../services/accomodation.service';
import { LoginService } from '../../services/login.service';

import { Message } from '../../model/Message';

@Component({
  selector: 'app-messsages',
  templateUrl: './messsages.component.html',
  styleUrls: ['./messsages.component.css']
})
export class MesssagesComponent implements OnInit {

  messages : Array<Message> = [];

  constructor(
    private loginService : LoginService, 
    private accomodationService: AccomodationService,
    private router : Router,
  ) { 
    this.accomodationService.getMessages().subscribe(
     messages => {this.messages = messages; console.log(messages)}
    );
  }

  ngOnInit() {
    

  }

  reply(id: number) : void {
    this.loginService.setShowMenu(false);
    this.router.navigate(['/message', id]);
  }

  

  

}
