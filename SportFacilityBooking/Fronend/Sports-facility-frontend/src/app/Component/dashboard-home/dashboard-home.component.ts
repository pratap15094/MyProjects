import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/entity/booking';
import { Facility } from 'src/app/entity/facility';
import { BookingService } from 'src/app/services/booking.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-dashboard-home',
  templateUrl: './dashboard-home.component.html',
  styleUrls: ['./dashboard-home.component.css']
})
export class DashboardHomeComponent implements OnInit {

  constructor(private bookingService: BookingService,private tokenstorage:TokenStorageService) { }
  fac: Facility[] = [];
  book: Booking[] = [];
  ngOnInit(): void {
    // const promise = this.bookingService.getAllfacilities();
    // promise.subscribe((response) => {
    //   this.fac = response as Facility[];
    // })

    const temp = this.tokenstorage.getUser();
    const promise = this.bookingService.getAllBookings(temp.id);
    promise.subscribe((response) => {
      this.book = response as Booking[];
    })
  }
}
