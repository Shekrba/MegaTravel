import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Data } from '@angular/router'
import { AdminServiceService } from '../admin-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-service',
  templateUrl: './edit-service.component.html',
  styleUrls: ['./edit-service.component.sass']
})
export class EditServiceComponent implements OnInit {

  usluga : Data = {
    naziv : null,
    cena : null,
    id : null,
    opis : null
  }

  constructor(private router: Router, private toastr: ToastrService, private ar: ActivatedRoute, private adminService: AdminServiceService) { }

  ngOnInit() {
    this.getService();
  }

  getService(){
    
    let id;

    this.ar.paramMap.subscribe(
      params => {
        id = params.get('id');
      }
    )

    this.adminService.getOneService(id).subscribe(
      res => {
        this.usluga = res;        
      },
      err => {
        alert("An error has occured while getting service " + id);
      }
    )
  }

  updateService(){
    this. adminService.updateService(this.usluga).subscribe(
      res => {
        this.showSuccess();
        this.router.navigate(['/services']);    
      },
      err => {
        alert("An error has occured while updating service " + this.usluga.id);
      }
    )
  }

  showSuccess() {
    if(1){
      this.toastr.success("Service successfully edited.", "Edit Service");  
    }
  }
}
