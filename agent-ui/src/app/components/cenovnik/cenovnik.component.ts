import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router } from "@angular/router";
import { AccomodationService } from '../../services/accomodation.service';
import { LoginService } from '../../services/login.service';
import { AccomodationUnit } from '../../model/AccomodationUnit';
import { Cenovnik } from '../../model/Cenovnik';
import { Mesec } from '../../model/Mesec';


@Component({
  selector: 'app-cenovnik',
  templateUrl: './cenovnik.component.html',
  styleUrls: ['./cenovnik.component.css']
})
export class CenovnikComponent implements OnInit {

  idAccomodation : number;
  idAccomodationUnit : number;

  cenovnik : Cenovnik = new Cenovnik();
  meseci : Array<Mesec> = [];


  constructor(
    private route : ActivatedRoute,
    private accomodationService: AccomodationService,
    private router : Router,
    private loginService : LoginService,
  ) { 
    this.meseci.push({ cena:0, mesec:'januar'});
    this.meseci.push({ cena:0, mesec:'februar'});
    this.meseci.push({ cena:0, mesec:'mart'});
    this.meseci.push({ cena:0, mesec:'april'});
    this.meseci.push({ cena:0, mesec:'maj'});
    this.meseci.push({ cena:0, mesec:'jun'});
    this.meseci.push({ cena:0, mesec:'jul'});
    this.meseci.push({ cena:0, mesec:'avgust'});
    this.meseci.push({ cena:0, mesec:'septembar'});
    this.meseci.push({ cena:0, mesec:'oktobar'});
    this.meseci.push({ cena:0, mesec:'novembar'});
    this.meseci.push({ cena:0, mesec:'decembar'});

    this.idAccomodation = parseInt(this.route.snapshot.paramMap.get("idAccomodation"));
    this.idAccomodationUnit = parseInt(this.route.snapshot.paramMap.get("idUnit"));
    
  }

  ngOnInit() {
  }

  save() : void {
    this.cenovnik.idSJedinice = this.idAccomodationUnit;
    this.cenovnik.listaMeseca = this.meseci;
    this.accomodationService.setCenovnik(this.idAccomodationUnit, this.cenovnik).subscribe(
      response => {
        window.alert('Cenovnik uspesno dodat!');
        this.loginService.setShowMenu(true);
        this.router.navigate(['/accomodationUnits',this.idAccomodation]);
      }
    );
  }
  back() : void {
    this.loginService.setShowMenu(true);
    this.router.navigate(['/accomodationUnits',this.idAccomodation]);
  }

  ispis() : void {
    console.log(this.meseci)
  }

}
