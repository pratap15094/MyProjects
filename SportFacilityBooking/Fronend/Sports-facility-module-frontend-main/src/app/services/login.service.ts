import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { login } from '../entity/login';
import { User } from '../entity/User';

const AUTH_API = 'http://localhost:8085/api/auth/';
const httpOptions = {
headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
providedIn: 'root'
})
export class LoginService {
constructor(private http: HttpClient) { }
login(login:login): Observable<any> {
return this.http.post(AUTH_API + 'signin',login, httpOptions);
}
register(user:User): Observable<any> {
return this.http.post(AUTH_API + 'signup',user, httpOptions);
}
}