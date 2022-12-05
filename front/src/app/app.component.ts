import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front';
  var1: any;
  constructor(public http: HttpClient){}
  
  
  

  giveMeData() {
    this.http.get('localhost:8080/overview').subscribe((resp) => {
      this.var1 = resp;
    })
  }

}