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
  
  komentari : Data = []

  constructor(private adminService: AdminServiceService) { }

  ngOnInit() {
    this.getAllComments();
  }

  getAllComments(){
    this.adminService.getAllComments().subscribe(
      res => {

        for(let i=0; i<res.length; i++){
          let ocena = res[i];
          
          this.adminService.getUsername(ocena.korisnik_id).subscribe(
            res => {
              let u = res;

              this.adminService.getSmestajNaziv(ocena.smestaj_id).subscribe(
                res => {
                  let s = res;

                  let kom = {
                    text : ocena.komentar,
                    id : ocena.ocena_id,
                    publish : ocena.published,
                    username : u,
                    smestaj : s
                  }
        
                  this.komentari.push(kom);
                },
                err => {
                  alert("An error has occured while getting a hotel name.");
                }
              )
            },
            err => {
              alert("An error has occured while getting a username.");
            }
          )
        }
      },
      err => {
        alert("An error has occured while getting all comments.");
      }
    )
  }

  publishButton(k){

    let body = {
      ocena_id : k.id,
      action : "publish"
    }

    this.adminService.publishing(body).subscribe(
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

    let body = {
      ocena_id : k.id,
      action : "unpublish"
    }

    this.adminService.publishing(body).subscribe(
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
