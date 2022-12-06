import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

import { isEmpty } from '../string-utilities';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  passwordHasError: boolean = false;
  pidHasError: boolean = false;


  loginForm = this.formBuilder.group({
    username: '',
    password: ''
  });



  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient
  ) { }

  token: string = '';

  onSubmit(): void {
    if (isEmpty(this.loginForm.value.password)) {
      this.passwordHasError = true;
    } else {
      this.passwordHasError = false;
    }
    if (isEmpty(this.loginForm.value.username)) {
      this.pidHasError = true;
    } else {
      this.pidHasError = false;
    }

    console.log(this.loginForm.value)

    if(!this.pidHasError && !this.passwordHasError) {
      this.http.post('http://localhost:8080/login', this.loginForm.value).subscribe((response) => { 
      this.token = JSON.stringify(response)
        localStorage.setItem('token', this.token)
      })
    }

    

  }
  ngOnInit(): void {

  }
}




