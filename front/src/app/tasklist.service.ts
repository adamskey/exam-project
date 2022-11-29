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
<<<<<<< HEAD
    //return this.http.get<{ id: number, taskCategory: number, createdTimestamp: Date, due: Date, edited: Date,
    //completed: Date, title:string, description: string, assignedTo: number, priorityId: number}[]>('localhost:8080/overview')
    return this.http.get('http://localhost:8080/overview')
    }
    
    
=======
return this.http.get<{ id: number, taskCategory: number, createdTimestamp: Date, due: Date, edited: Date,
    completed: Date, title:string, description: string, assignedTo: number, priorityId: number }[]>('localhost:8080/overview')
    }
>>>>>>> 8821301 (SQL connection works (json created in overview))

}