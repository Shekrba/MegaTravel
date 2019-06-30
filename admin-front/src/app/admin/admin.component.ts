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
    email :null,
    id:null
  }

  constructor(private toastr: ToastrService, private adminService: AdminServiceService, private router: Router) { }

  showSuccess() {
    this.toastr.success("Admin registration successful.", "Registration");
  }

  ngOnInit() {
  }

  registerAdmin(){
    
    if(this.admin.username == null || this.admin.username == ""){
      this.toastr.error("You have to input username.");
      return;
    }

    if(this.admin.password == null || this.admin.password == ""){
      this.toastr.error("You have to input password.");
      return;
    }

    if(this.admin.ime == null || this.admin.ime == ""){
      this.toastr.error("You have to input first name.");
      return;
    }

    if(this.admin.prezime == null || this.admin.prezime == ""){
      this.toastr.error("You have to input last name.");
      return;
    }

    if(this.admin.email == null || this.admin.email == ""){
      this.toastr.error("You have to input email.");
      return;
    }
    
    this.adminService.registerAdmin(this.admin).subscribe(
      res => {

        this.admin.id = res.id;

        if(this.admin.id==null){
          this.toastr.error("Username is already taken.");
        }
        else{
          this.router.navigate(['']);
          this.showSuccess();
        }
      },
      err => {
        this.toastr.error("Username already exists.", "Registration");
      }
    );
  }

}
