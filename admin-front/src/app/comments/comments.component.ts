import { Component, OnInit } from '@angular/core';
import { Button } from 'protractor';
import { Data } from '@angular/router';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.sass']
})
export class CommentsComponent implements OnInit {
  
  komentari : Data = [{
    username : null,
    text : null,
    smestaj : null,
    id : null,
    publish : false
  }]

  constructor(private adminService: AdminServiceService) { }

  ngOnInit() {
    this.getAllComments();
  }

  getAllComments(){
    this.adminService.getAllComments().subscribe(
      res => {
        this.komentari = res;
      },
      err => {
        alert("An error has occured while getting all comments.");
      }
    )
  }

  publishButton(k){

    this.adminService.publishing(k).subscribe(
      res => {
        let indexOfComment = this.komentari.indexOf(k);
        this.komentari[indexOfComment].publish = true;
      },
      err => {
        alert("An error has occured while publising a comment.");
      }
    )
  }

  removeButton(k){
    this.adminService.publishing(k).subscribe(
      res => {
        let indexOfComment = this.komentari.indexOf(k);
        this.komentari[indexOfComment].publish = false;
      },
      err => {
        alert("An error has occured while removing a comment.");
      }
    )
  }
}
