import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { AdminServiceService } from '../admin-service.service';
import { Data } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-agent',
  templateUrl: './agent.component.html',
  styleUrls: ['./agent.component.sass']
})
export class AgentComponent implements OnInit {
  
  agent : Data = {
    posMatBroj : null,
    ime : null,
    prezime : null,
    adresa : null,
    email :null,
    username: null,
    id:null
  }

  constructor(private toastr: ToastrService, private adminService: AdminServiceService, private router: Router) {}

  showSuccess() {
      this.toastr.success("Agent registration successful.", "Registration");
  }

  ngOnInit() {
  }

  registerAgent(){

    if(this.agent.username == null || this.agent.username == ""){
      this.toastr.error("You have to input username.");
      return;
    }

    if(this.agent.ime == null || this.agent.ime == ""){
      this.toastr.error("You have to input first name.");
      return;
    }

    if(this.agent.prezime == null || this.agent.prezime == ""){
      this.toastr.error("You have to input last name.");
      return;
    }

    if(this.agent.adresa == null || this.agent.adresa == ""){
      this.toastr.error("You have to input address.");
      return;
    }

    if(this.agent.posMatBroj == null || this.agent.posMatBroj == ""){
      this.toastr.error("You have to input business registration number.");
      return;
    }

    if(this.agent.email == null || this.agent.email == ""){
      this.toastr.error("You have to input email.");
      return;
    }

    if (isNaN(this.agent.posMatBroj)) {
      this.toastr.error("You have to input a number into business registration number.");
      return;
    }

    this.adminService.registerAgent(this.agent).subscribe(
      res => {
        this.agent.id = res.id;

        if(this.agent.id==null){
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
