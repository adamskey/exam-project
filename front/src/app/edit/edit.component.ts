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
    private categoryService: CategoryService,
    private priorityService: PriorityService,
  ){}
  categoryList!: Observable<{
    taskCategory:string
  }[]>;
  priorityList!:Observable<{
  priority:string
  }[]>;
  currentTask:any
  var1:any
  var2:any

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const taskIdFromRoute = Number(routeParams.get('taskId'))
    this.http.get('http://localhost:8080/tasks/detail/' + taskIdFromRoute).subscribe((response) => {
      console.log(response)
      this.currentTask = response;
    })

    this.priorityService.getPriorityList().subscribe((response)=>{
      this.var2 = response;
    })
    
    this.categoryService.getCategoryList().subscribe((response)=>{
      this.var1 = response;
    })

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
