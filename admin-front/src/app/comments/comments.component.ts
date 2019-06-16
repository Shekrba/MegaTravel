import { Component, OnInit } from '@angular/core';
import { Button } from 'protractor';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.sass']
})
export class CommentsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  publishButton(){
    document.getElementById("publish").hidden = true;
    document.getElementById("remove").hidden = false;
    
  }

  removeButton(){
    document.getElementById("publish").hidden = false;
    document.getElementById("remove").hidden = true;
  }
}
