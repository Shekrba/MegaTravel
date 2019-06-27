import { Component, OnInit } from '@angular/core';
import { HotelServiceService } from '../_services/hotel.service';
import { ToastrService } from 'ngx-toastr';
import { AuthenticationService } from '../_services/authentication.service';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-message',
  templateUrl: './new-message.component.html',
  styleUrls: ['./new-message.component.sass']
})
export class NewMessageComponent implements OnInit {

  message = {
    from:this.authService.currentUserValue.id,
    to:3,
    text:null
  }

  constructor(private hotelService : HotelServiceService,private router: Router, private toastr: ToastrService, private authService: AuthenticationService) { }

  ngOnInit() {
  }

  public newMessage(){

    if(this.message.text == null || this.message.text == ""){
      this.toastr.error("You must write a message first");
      return;
    }

    this.hotelService.newMessage(this.message).subscribe(
      res => {
          this.toastr.success(res);
          this.router.navigate(['/reservations']);
        
      },
      err => {
        alert("An error has occured while making a new message");
      }
    );
  }

}
