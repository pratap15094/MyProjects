import { HttpClient, HttpHeaders } from '@angular/common/http';
import { identifierModuleUrl } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../entity/Book';
import { BookDto } from '../entity/BookDto';
import { SubscribeEntity } from '../entity/SubscribeEntity';
const API_URL = 'http://ec2-54-161-213-236.compute-1.amazonaws.com:8081/api/test/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private http: HttpClient) { }

  createBook(book:Book,id:number):Observable<string>{
    return this.http.post<string>(API_URL+"createbook/"+id,book,httpOptions);
  }

  updateBook(book:Book,userid:number):Observable<string>{
    return this.http.put<string>(API_URL+"admin/updateBook/"+userid,book,httpOptions);
  }

  getbookIdbyTitle(title:string){
    return this.http.get(API_URL+"searchforupdate/"+title);
  }

  getAuthorNameByBookId(bookId:number){
    return this.http.get(API_URL+"getauthername/"+bookId);
  }

  getAuthorIdbyName(name:string){
    return this.http.get<number>(API_URL+"getauthoridbyname/"+name);
  }

  getBookListByAuthorId(id:number){
    return this.http.get(API_URL+"getbooklistbyauthorid/"+id);
  }

  blockBookByUserIdBookId(obj:SubscribeEntity):Observable<string>
  {
    return this.http.post<string>(API_URL+"addblock",obj,httpOptions);
  }
}
