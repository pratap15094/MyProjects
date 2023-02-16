import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booking } from '../entity/booking';
import { Observable } from 'rxjs';
import { UserDto } from '../entity/UserDto';

const AUTH_API = 'http://localhost:8085/api/test/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http: HttpClient) { }
  booking(booking: Booking): Observable<any> {
    return this.http.post(AUTH_API + 'createbooking', booking, httpOptions);
  }
  updateUser(user: UserDto): Observable<any> {
    return this.http.patch(AUTH_API + "updateuser", user, httpOptions);
  }

  getAllfacilities() {
    return this.http.get(AUTH_API + "allfacilities");
  }

  getAllBookings(id: number) {
    return this.http.get(AUTH_API + "getbookingsbyid/" + id);
  }
}
