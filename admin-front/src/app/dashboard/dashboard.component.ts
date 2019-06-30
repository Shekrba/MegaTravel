import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.sass']
})
export class DashboardComponent implements OnInit {

  constructor(private adminService:AdminServiceService) { }

  ngOnInit() {
    this.adminService.getAllUsers().subscribe(
      res => {
       
      },
      err => {
        
      }
    );
  }

}
