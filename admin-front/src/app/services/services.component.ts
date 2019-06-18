import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';
import { Data } from '@angular/router';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.sass']
})
export class ServicesComponent implements OnInit {

  usluge: Data = {
    naziv : null,
    opis : null,
    cena : null,
    id : null
  };

  constructor(private adminService: AdminServiceService) { }

  ngOnInit() {
    this.getAllServices();
  }

  public getAllServices(){
    this.adminService.getAllServices().subscribe(
      res => {
        this.usluge = res;
      },
      err => {
        alert("An error has occured while getting all services");
      }
    )
  }

}
