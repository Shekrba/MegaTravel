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
    username: null
  }

  constructor(private toastr: ToastrService, private adminService: AdminServiceService, private router: Router) {}

  showSuccess() {
      this.toastr.success("Agent registration successful.", "Registration");
  }

  ngOnInit() {
  }

  registerAgent(){
    this.adminService.registerAgent(this.agent).subscribe(
      res => {
        this.router.navigate(['']);
        this.showSuccess();
      },
      err => {
        alert("Could not register an agent.");
      }
    );
  }

}
