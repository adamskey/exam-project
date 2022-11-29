import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { TaskListService } from '../tasklist.service';

@Component({
  selector: 'app-oversiktsvy',
  templateUrl: './oversiktsvy.component.html',
  styleUrls: ['./oversiktsvy.component.css']
})

@Injectable()
export class OversiktsvyComponent implements OnInit{

  taskList!: Observable<{ id: number, taskCategory: number, createdTimestamp: Date, due: Date, edited: Date,
  completed: Date, title:string, description: string, assignedTo: number, priorityId: number }[]>;
  constructor(private taskListService: TaskListService){

  }

  ngOnInit(): void {
   this.taskList = this.taskListService.getTaskList();
  }


}
