import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TaskListService } from '../tasklist.service';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { OversiktsvyComponent } from '../oversiktsvy/oversiktsvy.component';
import { UnassignedComponent } from '../unassigned/unassigned.component';
import { ActivatedRoute, Router } from '@angular/router';
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
    private http: HttpClient,
    private router: Router
  ) { }


  currentTask: any;


  ngOnInit(): void {

    const routeParams = this.route.snapshot.paramMap;
    const taskIdFromRoute = Number(routeParams.get('taskId'))

    this.http.get('http://localhost:8080/tasks/detail/' + taskIdFromRoute).subscribe((response) => {
      this.currentTask = response;
    })

    console.log(this.currentTask)

  }

  deleteTask() {
    
    const routeParams = this.route.snapshot.paramMap;
    const taskIdFromRoute = Number(routeParams.get('taskId'))

    this.http.post('http://localhost:8080/tasks/delete', taskIdFromRoute).subscribe()
    this.router.navigate(['overview'])
  }

  completeTask() {

    const routeParams = this.route.snapshot.paramMap;
    const taskIdFromRoute = Number(routeParams.get('taskId'))

    this.http.post('http://localhost:8080/tasks/complete', taskIdFromRoute).subscribe()

    window.location.reload()
  }
}
