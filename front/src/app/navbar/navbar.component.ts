import { Component, } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import { AppComponent } from '../app.component';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent{



  constructor(private http: HttpClient) {}


   postSignout() {
    let user = 'hej';
    this.http.post('http://localhost:8080/api/auth/signout', user)
    window.location.href
   }

   
}

