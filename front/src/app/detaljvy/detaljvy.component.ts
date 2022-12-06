import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TaskListService } from '../tasklist.service';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { OversiktsvyComponent } from '../oversiktsvy/oversiktsvy.component';
import { Task } from '../app.task';
import { ActivatedRoute } from '@angular/router';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-detaljvy',
  templateUrl: './detaljvy.component.html',
  styleUrls: ['./detaljvy.component.css']
})
@Injectable()
export class DetaljvyComponent implements OnInit {

  constructor(
    private taskListService: TaskListService,
    private route: ActivatedRoute,
    public currentTask: Task,
    private formBuilder: FormBuilder,
    private app: AppComponent,
    private http: HttpClient
  ) { }


  var1: any;
  task: any;

  ngOnInit(): void {
 
    const routeParams = this.route.snapshot.paramMap;
    const taskIdFromRoute = Number(routeParams.get('taskId'))
    this.getDetails(taskIdFromRoute).subscribe((response) => {
      this.task = response;
    })
  }
  getDetails(id: number) {
    return this.http.get('http://localhost:8080/tasks/detail/' + id)
  }



}
