import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.sass']
})
export class UsersComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  activateButton(){
    var activate = <HTMLInputElement> document.getElementById("activate");
    var block = <HTMLInputElement> document.getElementById("block");
    
    activate.disabled=true;
    block.disabled=false;
  }

  blockButton(){
    var activate = <HTMLInputElement> document.getElementById("activate");
    var block = <HTMLInputElement> document.getElementById("block");

    activate.disabled=false;
    block.disabled=true;
  }

}
