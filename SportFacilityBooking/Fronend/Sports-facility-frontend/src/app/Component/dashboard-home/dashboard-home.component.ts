import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/entity/booking';
import { Facility } from 'src/app/entity/facility';
import { BookingService } from 'src/app/services/booking.service';

@Component({
  selector: 'app-dashboard-home',
  templateUrl: './dashboard-home.component.html',
  styleUrls: ['./dashboard-home.component.css']
})
export class DashboardHomeComponent implements OnInit {

  constructor(private bookingService:BookingService) { }
  fac:Facility[] = [];
  book:Booking[] = [];
  ngOnInit(): void {
    const promise = this.bookingService.getAllfacilities();
    promise.subscribe((response) => {
      this.fac = response as Facility[];
    })


    const promise1 = this.bookingService.getAllBookings;
    promise.subscribe((response) => {
      this.book = response as Booking[];
    })
    }
}
