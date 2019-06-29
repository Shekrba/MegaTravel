import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AgentComponent } from './agent/agent.component';
import { CommentsComponent } from './comments/comments.component';
import { UsersComponent } from './users/users.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ServicesComponent } from './services/services.component';
import { EditServiceComponent } from './edit-service/edit-service.component';
import { TypesComponent } from './types/types.component';
import { CategorizationComponent } from './categorization/categorization.component';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './_guards';

const routes: Routes = [
  { path: 'agent', component: AgentComponent , canActivate:[AuthGuard] },
  { path: 'comments', component: CommentsComponent , canActivate:[AuthGuard] },
  { path: 'users', component: UsersComponent , canActivate:[AuthGuard] },
  { path: '', component: DashboardComponent , canActivate:[AuthGuard]},
  { path: 'services', component: ServicesComponent , canActivate:[AuthGuard]},
  { path: 'services/:id', component: EditServiceComponent , canActivate:[AuthGuard]},
  { path: 'types', component: TypesComponent , canActivate:[AuthGuard]},
  { path: 'categorization', component: CategorizationComponent , canActivate:[AuthGuard]},
  { path: 'admin', component: AdminComponent , canActivate:[AuthGuard]},
  { path: 'login', component: LoginComponent},
  { path: '**', redirectTo: 'login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
