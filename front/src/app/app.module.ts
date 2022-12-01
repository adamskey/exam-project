import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DetaljvyComponent } from './detaljvy/detaljvy.component';
import { OversiktsvyComponent } from './oversiktsvy/oversiktsvy.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { NewticketComponent } from './newticket/newticket.component';
import { StatsComponent } from './stats/stats.component';
import { BodyComponent } from './body/body.component';



@NgModule({
  declarations: [
    AppComponent,
    DetaljvyComponent,
    OversiktsvyComponent,
    NavbarComponent,
    LoginComponent,
    NewticketComponent,
    StatsComponent,
    BodyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
