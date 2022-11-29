import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { NewticketComponent } from './newticket/newticket.component';
import { OversiktsvyComponent } from './oversiktsvy/oversiktsvy.component';

const routes: Routes = [
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'newticket', component: NewticketComponent
  },  
  {
    path: 'oversiktsvy', component: OversiktsvyComponent
  },
  {
    path: '', pathMatch: 'full', component: LoginComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }