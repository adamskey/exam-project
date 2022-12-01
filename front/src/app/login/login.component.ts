import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';

import { isEmpty } from '../string-utilities';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  passwordError = document.body.querySelector(".password-error");

  loginForm = this.formBuilder.group({
    pid: '',
    password: ''
  });
  
  

  constructor(
    private formBuilder: FormBuilder

  ) { }
  onSubmit(): void {
    if (isEmpty(this.loginForm.value.password) || isEmpty(this.loginForm.value.pid))
      console.log("STRÄNG ÄR TOM")
      this.passwordError?.classList.remove(".hidden")
      document.getElementById(".password-error")?.innerText == "HEJ"
  }

}




