import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TaskListService } from '../tasklist.service';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AppComponent } from '../app.component';
import { OversiktsvyComponent } from '../oversiktsvy/oversiktsvy.component';
import { Task } from '../app.task';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detaljvy',
  templateUrl: './detaljvy.component.html',
  styleUrls: ['./detaljvy.component.css']
})

export class DetaljvyComponent implements OnInit  {

  constructor(
    private taskListService: TaskListService,
    private route: ActivatedRoute,
    public currentTask: Task,
    private formBuilder: FormBuilder,
  ) {}


  var1: any;


  ngOnInit(): void {
    this.taskListService.getTaskListByUserId().subscribe((response) => {
      this.var1 = response;


    })

    const routeParams = this.route.snapshot.paramMap;
    const taskIdFromRoute = Number(routeParams.get('taskId'))

      for(let task in this.var1) {
        var obj = JSON.parse(task)
        if (obj.id == taskIdFromRoute) {
          this.currentTask = obj;
        }
      }

  }



}
