import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SubscribeEntity } from '../entity/SubscribeEntity';

const API_URL = 'http://ec2-54-161-213-236.compute-1.amazonaws.com:8081/api/test/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all');
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }

  getAllBook(){
    return this.http.get(API_URL+"all");
  }

  isBookBlocked(obj:SubscribeEntity):Observable<boolean>{
    return this.http.post<boolean>(API_URL+"isblocked",obj,httpOptions);
  }

  getAllBlockedBooksByUser(id:number){
    return this.http.get(API_URL+"blockedbooks/"+id);
  }
  
}