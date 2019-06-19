import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { AdminServiceService } from '../admin-service.service';
import { Data } from '@angular/router';

@Component({
  selector: 'app-categorization',
  templateUrl: './categorization.component.html',
  styleUrls: ['./categorization.component.sass']
})
export class CategorizationComponent implements OnInit {

  usluge: Data = [{
    naziv : null,
    opis : null,
    cena : null,
    id : null,
    categoryList : [{
      vrednost : null
    }]
  }];

  five: Data ={
    in : [],
    out : []
  };
  four: Data ={
    in : [],
    out : []
  };
  three: Data ={
    in : [],
    out : []
  };
  two: Data ={
    in : [],
    out : []
  };
  one: Data ={
    in : [],
    out : []
  };
  

  constructor(private toastr: ToastrService, private adminService: AdminServiceService) { }

  ngOnInit() {
    this.getAllServices();
  }

  showSuccess() {
    this.toastr.success("Changes applied.");
  }

  checkFive(ev, data) {

    if(ev.target.checked){
      
      let removeIndex = this.five.out.indexOf(data);
      if(removeIndex > -1){
        this.five.out.splice(removeIndex,1);
      }

      this.five.in.push(data);
    }else {
      let removeIndex = this.five.in.indexOf(data);
      if(removeIndex > -1){
        this.five.in.splice(removeIndex,1);
      }

      this.five.out.push(data);
    }

    console.log(this.five.in);
    console.log(this.five.out);
  }

  checkFour(ev, data) {

    if(ev.target.checked){
      
      let removeIndex = this.four.out.indexOf(data);
      if(removeIndex > -1){
        this.four.out.splice(removeIndex,1);
      }

      this.four.in.push(data);
    }else {
      let removeIndex = this.four.in.indexOf(data);
      if(removeIndex > -1){
        this.four.in.splice(removeIndex,1);
      }

      this.four.out.push(data);
    }

    console.log(this.four.in);
    console.log(this.four.out);
  }

  checkThree(ev, data) {

    if(ev.target.checked){
      
      let removeIndex = this.three.out.indexOf(data);
      if(removeIndex > -1){
        this.three.out.splice(removeIndex,1);
      }

      this.three.in.push(data);
    }else {
      let removeIndex = this.three.in.indexOf(data);
      if(removeIndex > -1){
        this.three.in.splice(removeIndex,1);
      }

      this.three.out.push(data);
    }

    console.log(this.three.in);
    console.log(this.three.out);
  }

  checkTwo(ev, data) {

    if(ev.target.checked){
      
      let removeIndex = this.two.out.indexOf(data);
      if(removeIndex > -1){
        this.two.out.splice(removeIndex,1);
      }

      this.two.in.push(data);
    }else {
      let removeIndex = this.two.in.indexOf(data);
      if(removeIndex > -1){
        this.two.in.splice(removeIndex,1);
      }

      this.two.out.push(data);
    }

    console.log(this.two.in);
    console.log(this.two.out);
  }

  checkOne(ev, data) {

    if(ev.target.checked){
      
      let removeIndex = this.one.out.indexOf(data);
      if(removeIndex > -1){
        this.one.out.splice(removeIndex,1);
      }

      this.one.in.push(data);
    }else {
      let removeIndex = this.one.in.indexOf(data);
      if(removeIndex > -1){
        this.one.in.splice(removeIndex,1);
      }

      this.one.out.push(data);
    }

    console.log(this.one.in);
    console.log(this.one.out);
  }

  public getAllServices(){
    this.adminService.getAllServices().subscribe(
      res => {
        console.log(res);
        this.usluge = res;

        for(let i = 0; i<this.usluge.length; i++){
          let usl = this.usluge[i];

          let flag5 = false;
          let flag4 = false;
          let flag3 = false;
          let flag2 = false;
          let flag1 = false;

          for(let j = 0; j<usl.categoryList.length; j++){
            
            let cat = this.usluge[i].categoryList[j];
            
            if(cat.vrednost == 5){
              this.five.in.push(usl);
              flag5=true;
              continue;
            }

            if(cat.vrednost == 4){
              this.four.in.push(usl);
              flag4=true;
              continue;
            }

            if(cat.vrednost == 3){
              this.three.in.push(usl);
              flag3=true;
              continue;
            }

            if(cat.vrednost == 2){
              this.two.in.push(usl);
              flag2=true;
              continue;
            }

            if(cat.vrednost == 1){
              this.one.in.push(usl);
              flag1=true;
              continue;
            }
          }

          if(flag5==false){
            this.five.out.push(usl);
          }

          if(flag4==false){
            this.four.out.push(usl);
          }

          if(flag3==false){
            this.three.out.push(usl);
          }

          if(flag2==false){
            this.two.out.push(usl);
          }

          if(flag1==false){
            this.one.out.push(usl);
          }

        }

        
      },
      err => {
        alert("An error has occured while getting all services.");
      }
    )
  }

  public setServicesForCategory(catId,services){

    let chosen : Data = {
      services : []
    };
    for (let i =0; i < services.length; i++){
      chosen.services.push(services[i].id);
    }

    this.adminService.setServicesForCategory(catId,chosen).subscribe(
      res => {
        this.showSuccess();
      },
      err => {
        alert("Could not add service");
      }
    );
  }
}
