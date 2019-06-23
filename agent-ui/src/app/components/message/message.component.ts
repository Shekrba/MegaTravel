import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';
import { AccomodationService } from '../../services/accomodation.service';
import { LoginService } from '../../services/login.service';

import { Message } from '../../model/Message';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  idMessage : number;
  message : Message = new Message();
  answerMessage : Message = new Message();

  constructor(
    private loginService : LoginService, 
    private accomodationService: AccomodationService,
    private router : Router,
    private route: ActivatedRoute
  ) { 
    this.idMessage = parseInt(this.route.snapshot.paramMap.get("id"));
    this.accomodationService.getMessage(this.idMessage).subscribe(
      message => {this.message = message; console.log(message)}
    );
  }

  ngOnInit() {
  }

  reply() : void {
    const { id, posaljilac, primalac } = this.message;
    this.answerMessage.posaljilac = primalac;
    this.answerMessage.primalac = posaljilac;
    this.accomodationService.answerMessage(this.idMessage,this.answerMessage).subscribe(
      response => {
        window.alert('Poruka je uspesno poslata!');
        this.loginService.setShowMenu(true);
        this.router.navigate(['/messages']);
      }
    );

  }

  cancel() : void {
    this.loginService.setShowMenu(true);
    this.router.navigate(['/messages']);
  }

}
