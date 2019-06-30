import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';
import { Data } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-types',
  templateUrl: './types.component.html',
  styleUrls: ['./types.component.sass']
})
export class TypesComponent implements OnInit {

  types : Data = [{
    id : null,
    naziv : null
  }]

  type : Data = {
    naziv : null
  }

  constructor(private adminService: AdminServiceService, private toastr: ToastrService) { }

  ngOnInit() {
    this.getAllTypes();
  }

  getAllTypes(){
    this.adminService.getAllTypes().subscribe(
      res => {
        this.types = res;
      },
      err => {
        alert("An error has occured while getting all types.");
      }
    )
  }

  public addType(){

    if(this.type.naziv == null || this.type.naziv == ""){
      this.toastr.error("You have to input type name.");
      return;
    }

    this.adminService.addType(this.type).subscribe(
      res => {
        this.types.push(res);
        this.type.naziv=null;
      },
      err => {
        alert("Could not add type.");
      }
    );
  }

  public deleteType(t){

    this.adminService.deleteType(t.id).subscribe(
      res => {

        if(res == "Deleted successfully"){
          let indexOfType = this.types.indexOf(t);
          this.types.splice(indexOfType,1);
          this.toastr.success(res);
        }

        else if(res == "Can not delete type. It is contained in one or more accommodations"){
          this.toastr.warning(res);
        }

      },
      err => {
        alert("An error has occured while deleting a type.");
      }
    );
  }

}
