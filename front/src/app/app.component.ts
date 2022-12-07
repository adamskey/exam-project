import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';

import { NavbarComponent } from './navbar/navbar.component';
import {Router} from '@angular/router'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  template:  `  
   <app-header></app-header>
  <router-outlet></router-outlet>
`,
styles: []
})

export class AppComponent {
  title = 'front';
  var1: any;
  public searchFilter: any = '';
  constructor(public http: HttpClient, public router:Router){}
  
  
  

  giveMeData() {
    this.http.get('localhost:8080/overview').subscribe((resp) => {
      this.var1 = resp;
    })
  }

  


}