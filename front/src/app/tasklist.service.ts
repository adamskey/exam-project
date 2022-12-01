import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
  })
export class TaskListService{
    constructor(
        private http: HttpClient
    ){}

    getTaskList(){
    return this.http.get('http://localhost:8080/overview')
    }

    getTaskListByUserId() {
        return this.http.get('http://localhost:8080/overview2')
    }
    
    

}