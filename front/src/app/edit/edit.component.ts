import { Component, OnInit, Injectable, Inject } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { isEmpty } from '../string-utilities';
import { AppComponent } from '../app.component';
import { CategoryService } from '../category.service';
import { PriorityService } from '../priority.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
@Injectable()
export class EditComponent implements OnInit {

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
    private http: HttpClient,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private app: AppComponent,
  ){}

  currentTask:any

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const taskIdFromRoute = Number(routeParams.get('taskId'))

  }
  onSubmit(): void {
    this.saveTask()
  }
  saveTask() {
    this.http.post('http://localhost:8080/tasks/newtask', this.newticketForm.value).subscribe((response) =>{
      console.log(response)
    })
    
  }



}
