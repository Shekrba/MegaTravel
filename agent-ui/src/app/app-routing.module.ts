import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component'; 
import { AccomodationsComponent } from './components/accomodations/accomodations.component';
import { LoginComponent } from './components/login/login.component';
import { AccommodationComponent } from './components/accommodation/accommodation.component';
import { AccomodationUnitsComponent } from './components/accomodation-units/accomodation-units.component';
import { EditAccomodationComponent } from './components/edit-accomodation/edit-accomodation.component';
import { AccomodationUnitComponent } from './components/accomodation-unit/accomodation-unit.component';
import { EditAccomodationUnitComponent } from './components/edit-accomodation-unit/edit-accomodation-unit.component';
import { ReservationsComponent } from './components/reservations/reservations.component';
import { MesssagesComponent } from './components/messsages/messsages.component';
import { MessageComponent } from './components/message/message.component';
import { OccupancyComponent } from './components/occupancy/occupancy.component';


const routes : Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '', component: AppComponent, children: [
  { path: 'login', component: LoginComponent },
  { path: 'accomodations', component: AccomodationsComponent },
  { path: 'accomodation', component: AccommodationComponent },
  { path: 'accomodationUnits/:id', component: AccomodationUnitsComponent },
  { path: 'editAccomodation/:id', component: EditAccomodationComponent },
  { path: 'accomodationUnit/:id', component: AccomodationUnitComponent },
  { path: 'editAccomodationUnit/:idAccomodation/:idUnit', component : EditAccomodationUnitComponent },
  { path: 'reservations/:idAccomodation/:idUnit', component: ReservationsComponent },
  { path: 'messages', component: MesssagesComponent },
  { path: 'message/:id', component: MessageComponent },
  { path: 'occupancy/:idAccomodation/:idUnit', component: OccupancyComponent }]}
];


@NgModule({
  imports: [
   RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
