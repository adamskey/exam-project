import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TaskListService } from '../tasklist.service';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { OversiktsvyComponent } from '../oversiktsvy/oversiktsvy.component';
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
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private app: AppComponent,
    private http: HttpClient
  ) { }


  currentTask: any;


  ngOnInit(): void {

    const routeParams = this.route.snapshot.paramMap;
    const taskIdFromRoute = Number(routeParams.get('taskId'))

    this.http.get('http://localhost:8080/tasks/detail/' + taskIdFromRoute).subscribe((response) => {
      console.log(response)
      this.currentTask = response;
    })

    console.log(this.currentTask)

  }



}
