import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { AdminServiceService } from '../admin-service.service';
import { Router, Data } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.sass']
})
export class AdminComponent implements OnInit {

  admin : Data = {
    ime : null,
    prezime : null,
    username: null,
    password: null,
    email :null
  }

  constructor(private toastr: ToastrService, private adminService: AdminServiceService, private router: Router) { }

  showSuccess() {
    this.toastr.success("Admin registration successful.", "Registration");
  }

  ngOnInit() {
  }

  registerAdmin(){
    this.adminService.registerAdmin(this.admin).subscribe(
      res => {
        this.router.navigate(['']);
        this.showSuccess();
      },
      err => {
        alert("Could not register an admin.");
      }
    );
  }

}
