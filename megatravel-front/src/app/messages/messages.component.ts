import { Component, OnInit } from '@angular/core';
import { HotelServiceService } from '../_services/hotel.service';
import { AuthenticationService } from '../_services/authentication.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.sass']
})
export class MessagesComponent implements OnInit {

  tab : string = 'inbox'

  porukeInbox = [];
  porukeSent = [];

  constructor(private hotelService : HotelServiceService, private authService: AuthenticationService) { }

  ngOnInit() {
    this.getInboxMessages();
    this.getSentMessages();
  }

  public getInboxMessages(){
    let userId = this.authService.currentUserValue.id

    this.hotelService.getInboxMessages(userId).subscribe(
      res => {
        this.porukeInbox = res;
      },
      err => {
        alert("An error has occured while getting messages");
      }
    )
  }

  public getSentMessages(){
    let userId = this.authService.currentUserValue.id

    this.hotelService.getSentMessages(userId).subscribe(
      res => {
        this.porukeSent = res;
      },
      err => {
        alert("An error has occured while getting messages");
      }
    )
  }

  public inboxButton(){
    this.getInboxMessages();
    this.tab = 'inbox';
  }

  public sentButton(){
    this.getSentMessages();
    this.tab = 'sent';
  }

}
