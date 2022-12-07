import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


import { AppComponent } from '../app.component';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private http: HttpClient,
    private route: Router) {}

   postSignout() {
    localStorage.clear();
    this.route.navigate(['/login'])
   }

}

