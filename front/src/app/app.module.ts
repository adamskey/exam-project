import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DetaljvyComponent } from './detaljvy/detaljvy.component';
import { OversiktsvyComponent } from './oversiktsvy/oversiktsvy.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { NewticketComponent } from './newticket/newticket.component';
import { StatsComponent } from './stats/stats.component';
import { BodyComponent } from './body/body.component';
import { SearchPipe } from './search.pipe';



@NgModule({
  declarations: [
    AppComponent,
    DetaljvyComponent,
    OversiktsvyComponent,
    NavbarComponent,
    LoginComponent,
    NewticketComponent,
    StatsComponent,
    BodyComponent,
    SearchPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
