import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';

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
    pid: '',
    password: ''
  });

  constructor(
    private formBuilder: FormBuilder,
    private router: Router

  ) { }
  onSubmit(): void {
    if (isEmpty(this.loginForm.value.password)) {
      this.passwordHasError = true;
    } else {
      this.passwordHasError = false;
    }
    if (isEmpty(this.loginForm.value.pid)) {
      this.pidHasError = true;
    } else {
      this.pidHasError = false;
    }
    this.router.navigate(['/overview']);

  }
  ngOnInit(): void {
      
  }
}




