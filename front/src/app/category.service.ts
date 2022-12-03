import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class CategoryService{

constructor(
    private http: HttpClient
){}

getCategoryList(){
    return this.http.get('http://localhost:8080/taskcategory/all')
}

}