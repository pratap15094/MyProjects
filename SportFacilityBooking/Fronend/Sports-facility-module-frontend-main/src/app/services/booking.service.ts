import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booking } from '../entity/booking';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8085/api/Test/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http: HttpClient) { }
  booking(booking: Booking): Observable<any> {
      return this.http.post(AUTH_API + 'booking', booking, httpOptions);
  }
}
