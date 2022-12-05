import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormBuilder, FormControl } from '@angular/forms';
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
  searchForm:any;

  constructor(
    private taskListService: TaskListService,
    private app: AppComponent,
    private formBuilder: FormBuilder
  ) {
    this.searchForm = formBuilder.group({
      search: '',
    });
  }

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
