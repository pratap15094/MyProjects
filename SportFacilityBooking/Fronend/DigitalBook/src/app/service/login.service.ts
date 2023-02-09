import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegisterUser } from '../entity/registerUser';
const api = "http://ec2-54-161-213-236.compute-1.amazonaws.com:8081/api/auth";
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  requestHeader = new HttpHeaders({ "No-Auth": "True" });
  constructor(private httpClient:HttpClient) { }

  readerLogin(username: string, password: string):Observable<any>{
    return this.httpClient.post<any>(api+"/signin",{
      username,
      password
    }
    , httpOptions);
  }
  register(register:RegisterUser): Observable<any> {
    return this.httpClient.post(api + '/signup', register, httpOptions);
  }
}
