import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HotelsComponent } from './hotels/hotels.component'; 
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HotelProfileComponent } from './hotel-profile/hotel-profile.component';
import { AuthGuard } from './_guards';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'hotels', component: HotelsComponent/*, canActivate:[AuthGuard] //enable this to protect route from unauthenticated access*/ },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'hotels/:id', component: HotelProfileComponent },
  //redirect to home if url is not valid
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
