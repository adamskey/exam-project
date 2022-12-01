import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';

import { isEmpty } from '../string-utilities';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  passwordHasError:boolean = false;
  pidHasError:boolean = false;


  loginForm = this.formBuilder.group({
    pid: '',
    password: ''
  });
  
  

  constructor(
    private formBuilder: FormBuilder

  ) { }
  onSubmit(): void {
    if (isEmpty(this.loginForm.value.password)){
      this.passwordHasError = true;

  }
  if (isEmpty(this.loginForm.value.pid)){
    this.pidHasError = true;
  }

}
}




