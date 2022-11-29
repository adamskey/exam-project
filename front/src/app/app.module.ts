import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DetaljvyComponent } from './detaljvy/detaljvy.component';
import { OversiktsvyComponent } from './oversiktsvy/oversiktsvy.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { LoginComponent } from './login/login.component';
import { NewticketComponent } from './newticket/newticket.component';
import { StatsComponent } from './stats/stats.component';

@NgModule({
  declarations: [
    AppComponent,
    DetaljvyComponent,
    OversiktsvyComponent,
    NavbarComponent,
    SidebarComponent,
    LoginComponent,
    NewticketComponent,
    StatsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
