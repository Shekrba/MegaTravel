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

const routes: Routes = [
  { path: 'agent', component: AgentComponent },
  { path: 'comments', component: CommentsComponent },
  { path: 'users', component: UsersComponent },
  { path: '', component: DashboardComponent},
  { path: 'services', component: ServicesComponent},
  { path: 'services/:id', component: EditServiceComponent },
  { path: 'types', component: TypesComponent },
  { path: 'categorization', component: CategorizationComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
