import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';

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
    private formBuilder: FormBuilder

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

  }
  ngOnInit(): void {

  }
}




