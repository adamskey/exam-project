import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
  })
export class PriorityService{
    constructor(
        private http: HttpClient
    ){}


    getPriorityList(){
    return this.http.get('http://localhost:8080/priority/all')

    }
}