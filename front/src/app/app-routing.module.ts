import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { NewticketComponent } from './newticket/newticket.component';
import { OversiktsvyComponent } from './oversiktsvy/oversiktsvy.component';
import { DetaljvyComponent } from './detaljvy/detaljvy.component';
import { StatsComponent } from './stats/stats.component'
const routes: Routes = [
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'newticket', component: NewticketComponent
  },
  {
    path: 'overview', component: OversiktsvyComponent
  },
  {
    path: '', pathMatch: 'full', component: LoginComponent
  },
  {
    path: 'detail', component: DetaljvyComponent
  },
  {
  path: 'statistics', component: StatsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
