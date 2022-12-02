import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';

import { isEmpty } from '../string-utilities';

@Component({
  selector: 'app-newticket',
  templateUrl: './newticket.component.html',
  styleUrls: ['./newticket.component.css']
})
export class NewticketComponent implements OnInit {
 categoryIsEmpty: boolean = false;
  titleIsEmpty: boolean = false;
  descriptionIsEmpty: boolean = false;
  enddateIsEmpty: boolean = false;
  assigntoIsEmpty: boolean = false;

newticketForm = this.formBuilder.group({
    category: '',
    title: '',
    description: '',
    enddate: '',
    assignto: '',

  });

  constructor(
    private formBuilder: FormBuilder

  ) { }
  onSubmit(): void {
  if (this.newticketForm.value.category == '' || isEmpty(this.newticketForm.value.category)){
  this.categoryIsEmpty = true;
  } else {
  this.categoryIsEmpty = false;
  }
    if (isEmpty(this.newticketForm.value.title)) {
      this.titleIsEmpty = true;
    } else {
      this.titleIsEmpty = false;
    }
    if (isEmpty(this.newticketForm.value.description)) {
      this.descriptionIsEmpty = true;
    } else {
      this.descriptionIsEmpty = false;
    }
    if (this.newticketForm.value.enddate == ""){
    this.enddateIsEmpty = true;
    } else {
    this.enddateIsEmpty = false;
    }
    if (isEmpty(this.newticketForm.value.assignto)){
    this.assigntoIsEmpty = true;
    } else {
    this.assigntoIsEmpty = false;
    }
  }
  ngOnInit(): void {

  }
}
