import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private http: HttpClient) {}

   postSignout() {
    this.http.post('http://localhost:8080/api/auth/signout')
   }

}

