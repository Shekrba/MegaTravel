import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AuthGuard } from '../app/_guards';
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
  
  { path: 'login', component: LoginComponent },
  { path: 'accomodations', component: AccomodationsComponent, canActivate:[AuthGuard] },
  { path: 'accomodation', component: AccommodationComponent, canActivate:[AuthGuard] },
  { path: 'accomodationUnits/:id', component: AccomodationUnitsComponent, canActivate:[AuthGuard] },
  { path: 'editAccomodation/:id', component: EditAccomodationComponent, canActivate:[AuthGuard] },
  { path: 'accomodationUnit/:id', component: AccomodationUnitComponent, canActivate:[AuthGuard] },
  { path: 'editAccomodationUnit/:idAccomodation/:idUnit', component : EditAccomodationUnitComponent, canActivate:[AuthGuard] },
  { path: 'reservations/:idAccomodation/:idUnit', component: ReservationsComponent, canActivate:[AuthGuard] },
  { path: 'messages', component: MesssagesComponent, canActivate:[AuthGuard] },
  { path: 'message/:id', component: MessageComponent,canActivate:[AuthGuard] },
  { path: 'occupancy/:idAccomodation/:idUnit', component: OccupancyComponent, canActivate:[AuthGuard] }
];


@NgModule({
  imports: [
   RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
