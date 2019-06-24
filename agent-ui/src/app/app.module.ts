import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { AccommodationComponent } from './components/accommodation/accommodation.component';
import { LoginComponent } from './components/login/login.component';
import { AccomodationsComponent } from './components/accomodations/accomodations.component';
import { AppRoutingModule } from './app-routing.module';
import { AccomodationUnitsComponent } from './components/accomodation-units/accomodation-units.component';
import { AccomodationUnitComponent } from './components/accomodation-unit/accomodation-unit.component';
import { EditAccomodationComponent } from './components/edit-accomodation/edit-accomodation.component';
import { EditAccomodationUnitComponent } from './components/edit-accomodation-unit/edit-accomodation-unit.component';
import { ReservationsComponent } from './components/reservations/reservations.component';
import { MesssagesComponent } from './components/messsages/messsages.component';
import { MessageComponent } from './components/message/message.component';
import { OccupancyComponent } from './components/occupancy/occupancy.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    AccommodationComponent,
    LoginComponent,
    AccomodationsComponent,
    AccomodationUnitsComponent,
    AccomodationUnitComponent,
    EditAccomodationComponent,
    EditAccomodationUnitComponent,
    ReservationsComponent,
    MesssagesComponent,
    MessageComponent,
    OccupancyComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
