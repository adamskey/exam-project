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
    //return this.http.get<{ id: number, taskCategory: number, createdTimestamp: Date, due: Date, edited: Date,
    //completed: Date, title:string, description: string, assignedTo: number, priorityId: number}[]>('localhost:8080/overview')
    return this.http.get('http://localhost:8080/tasks/overview')
    }

    getTaskListByUserId() {
        const userString = localStorage.getItem('token')
        let userObject: {createdDate: string, email: string, id: number, password: string, phoneNumber: string, reportsTo: string, 
            role:[{id: number, name:string}], teamId: {id: number, name: string}, username: string}
        let id: number = 0
        if (userString != null) {
            userObject = JSON.parse(userString)
            id = userObject.id;
        }

        return this.http.post('http://localhost:8080/tasks/overview2', id)
    }

    getTaskListByTeamId() {
        const userString = localStorage.getItem('token')
        let userObject: {createdDate: string, email: string, id: number, password: string, phoneNumber: string, reportsTo: string, 
            role:[{id: number, name:string}], teamId: {id: number, name: string}, username: string}
            let teamId: number = 0
            if (userString != null) {
                userObject = JSON.parse(userString)
                teamId = userObject.teamId.id
            }

    return this.http.post('http://localhost:8080/tasks/overviewbyteam', teamId)
    }

}
