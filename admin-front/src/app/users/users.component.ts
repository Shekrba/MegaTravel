import { Component, OnInit } from '@angular/core';
import { Data } from '@angular/router';
import { AdminServiceService } from '../admin-service.service';
import { AuthenticationService } from '../_services/authentication.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.sass']
})
export class UsersComponent implements OnInit {

  users : Data = [{
    username : null,
    id : null,
    status : null
  }]

  constructor(private adminService: AdminServiceService, private authService:AuthenticationService) { }

  ngOnInit() {
    this.getAllUsers();
  }

  getAllUsers(){
    this.adminService.getAllUsers().subscribe(
      res => {
        this.users = res;
      },
      err => {
        alert("An error has occured while getting all users.");
      }
    )
  }

  activateButton(u){
    this.adminService.activateUser(u).subscribe(
      res => {
        let indexOfUser = this.users.indexOf(u);
        this.users[indexOfUser].status = 'ACTIVE';
      },
      err => {
        alert("An error has occured while activating a user.");
      }
    )
  }

  blockButton(u){
    this.adminService.blockUser(u).subscribe(
      res => {
        let indexOfUser = this.users.indexOf(u);
        this.users[indexOfUser].status = 'BLOCKED';
      },
      err => {
        alert("An error has occured while blocking a user.");
      }
    )
  }

  deleteButton(u){
    this.adminService.deleteUser(u).subscribe(
      res => {
        let indexOfUser = this.users.indexOf(u);
        this.users.splice(indexOfUser,1);
      },
      err => {
        alert("An error has occured while deleting a user.");
      }
    )
  }
}
