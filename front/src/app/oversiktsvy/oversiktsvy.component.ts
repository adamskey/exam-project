import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormControl } from '@angular/forms';
import { TooltipPosition} from '@angular/material/tooltip';
import { Pipe, PipeTransform } from '@angular/core';


import { TaskListService } from '../tasklist.service';
import { AppComponent } from '../app.component';
import { SearchPipe } from '../search.pipe';


@Component({
  selector: 'app-oversiktsvy',
  templateUrl: './oversiktsvy.component.html',
  styleUrls: ['./oversiktsvy.component.css']
})

@Injectable()
export class OversiktsvyComponent implements OnInit {
  public searchFilter: any = '';

  
  positionOptions: TooltipPosition[] = ['right'];
  position = new FormControl(this.positionOptions[0]);


  constructor(
    private taskListService: TaskListService,
    private app: AppComponent
  ) {}
  var1: any;
  

  taskList!: Observable<{
    id: number, taskCategory: number, createdTimestamp: Date, due: Date, edited: Date,
    completed: Date, title: string, description: string, assignedTo: number, priorityId: number
  }[]>;

  ngOnInit(): void {
    this.taskListService.getTaskListByUserId().subscribe((response) => {
      this.var1 = response;
    })
    console.log(this.var1)
  }
  



}
