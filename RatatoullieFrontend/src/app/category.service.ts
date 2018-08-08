import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }

  getCategories() {
    return this.http.get('https://private-c884ad-testapi3740.apiary-mock.com/resto');
    //https://private-16bb7-ratatoullie.apiary-mock.com/listCategory
  }
}
