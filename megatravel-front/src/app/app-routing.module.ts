import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HotelsComponent } from './hotels/hotels.component'; 
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HotelProfileComponent } from './hotel-profile/hotel-profile.component';
import { RatingsComponent } from './ratings/ratings.component'
import { ReservationComponent } from './reservation/reservation.component';
import { AuthGuard } from './_guards';
import { ManageReservationsComponent } from './manage-reservations/manage-reservations.component';
import { NewMessageComponent } from './new-message/new-message.component';
import { MessagesComponent } from './messages/messages.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'hotels', component: HotelsComponent/*, canActivate:[AuthGuard] //enable this to protect route from unauthenticated access*/ },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'hotels/:id', component: HotelProfileComponent },
  { path: 'ratings', component: RatingsComponent, canActivate:[AuthGuard] },
  { path: 'reservation', component: ReservationComponent, canActivate:[AuthGuard] },
  { path: 'reservations', component: ManageReservationsComponent, canActivate:[AuthGuard] },
  { path: 'newmessage' ,component: NewMessageComponent, canActivate:[AuthGuard] },
  { path: 'messages', component: MessagesComponent, canActivate:[AuthGuard] },
  //redirect to home if url is not valid
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
