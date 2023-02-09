import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SubscribeEntity } from '../entity/SubscribeEntity';
const API_URL = 'http://ec2-54-161-213-236.compute-1.amazonaws.com:8081/api/test/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {
  constructor(private http: HttpClient) { }
  
  subscribeBook(subscribe:SubscribeEntity){
    return this.http.post(API_URL+'subscribe/create',subscribe,httpOptions);
  }

  getSubscribedBook(userid:number){
    return this.http.get(API_URL+'subscribedbooks/'+userid);
  }

  unsubscribeBook(subscribeId:number):Observable<string>{
    return this.http.delete<string>(API_URL+'unsubscribe/'+subscribeId);
  }

  getSubscriptionId(subscribe:SubscribeEntity){
    return this.http.post(API_URL+"getsubscriptionid",subscribe,httpOptions);
  }

}
