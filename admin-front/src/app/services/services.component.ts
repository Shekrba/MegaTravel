import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';
import { Data } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { isNumber } from 'util';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.sass']
})
export class ServicesComponent implements OnInit {

  usluge: Data = [{
    naziv : null,
    opis : null,
    cena : null,
    id : null
  }];

  usl: Data = {
    naziv : null,
    opis : null,
    cena :null
  }

  constructor(private adminService: AdminServiceService, private toastr: ToastrService) { }

  ngOnInit() {
    this.getAllServices();
  }

  public getAllServices(){
    this.adminService.getAllServices().subscribe(
      res => {
        this.usluge = res;
      },
      err => {
        alert("An error has occured while getting all services.");
      }
    )
  }

  public deleteService(usluga){

    this.adminService.deleteService(usluga.id).subscribe(
      res => {
        let indexOfService = this.usluge.indexOf(usluga);
        this.usluge.splice(indexOfService,1);
      },
      err => {
        alert("Could not delete service");
      }
    );
  }

  public addService(){

    if(this.usl.naziv == null || this.usl.naziv == ""){
      this.toastr.error("You have to input service name.");
      return;
    }

    if(this.usl.cena == null || this.usl.cena == ""){
      this.toastr.error("You have to input service price.");
      return;
    }

    if (isNaN(this.usl.cena)) {
      this.toastr.error("You have to input a number into service price.");
      return;
    }

    this.adminService.addService(this.usl).subscribe(
      res => {
        this.usluge.push(res);
        this.usl.naziv=null;
        this.usl.opis=null;
        this.usl.cena=null;
      },
      err => {
        alert("Could not add service");
      }
    );
  }

}
