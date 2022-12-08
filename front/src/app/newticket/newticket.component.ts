import { Component, OnInit, Injectable } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { isEmpty } from '../string-utilities';
import { AppComponent } from '../app.component';
import { CategoryService } from '../category.service';
import { PriorityService } from '../priority.service';
import { Router } from '@angular/router';

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
    id: '',
    category: '',
    priority:'',
    title: '',
    description: '',
    enddate: '',
    assignto: '',

  });

  constructor(
    private formBuilder: FormBuilder,
    private categoryService: CategoryService,
    private priorityService: PriorityService,
    private http: HttpClient,
    private router: Router
  ) { }
  var1:any
  var2:any

categoryList!: Observable<{
  taskCategory:string
}[]>;
priorityList!:Observable<{
priority:string
}[]>;

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
   if(!this.categoryIsEmpty || !this.titleIsEmpty || !this.descriptionIsEmpty || !this.enddateIsEmpty ){
    this.saveTask();
    this.router.navigate(["/overview"])
   }

  }
  ngOnInit(): void {
    this.priorityService.getPriorityList().subscribe((response)=>{
      this.var2 = response;
    })
    
    this.categoryService.getCategoryList().subscribe((response)=>{
      this.var1 = response;
    })
    console.log(this.var1)

  }

  saveTask() {
    this.http.post('http://localhost:8080/tasks/newtask', this.newticketForm.value).subscribe((response) =>{
      console.log(response)
    })
  
    
  }
}
