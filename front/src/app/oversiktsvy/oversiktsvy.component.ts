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
  searchText: any;
  ChosenId: boolean = false;

  constructor(
    private taskListService: TaskListService,
    private app: AppComponent,
    private formBuilder: FormBuilder
  ) { }

  var1: any;
  p: number = 1;
  count: number = 10;

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
  onSubmit(): void {
    if (this.ChosenId != this.var1) {
      this.ChosenId = true;
    } else {
      this.ChosenId = false;
    }
  }
}
