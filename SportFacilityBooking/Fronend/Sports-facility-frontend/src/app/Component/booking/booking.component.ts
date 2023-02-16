import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Booking } from 'src/app/entity/booking';
import { User } from 'src/app/entity/User';
import { BookingService } from 'src/app/services/booking.service';
import { LoginService } from 'src/app/services/login.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {


  booking = new Booking();
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  tmp:any;
  constructor(private authService: BookingService, private router: Router,private token:TokenStorageService) { }

  ngOnInit(): void {
  }
  id:number;
  onSubmit(f: NgForm): void {

    // console.log(this.register.role)
    // console.log(this.register.username);
  //   this.authService.booking(this.booking).subscribe(
  //     data => {
  //       console.log(data);
  //       this.isSuccessful = true;
  //       this.isSignUpFailed = false;
  //       f.resetForm();
  //       alert("Registered Successfully!");
  //       this.router.navigate(['/login'])
  //     },
  //     err => {
  //       this.errorMessage = err.error.message;
  //       this.isSignUpFailed = true;
  //     }
  //   );
  console.log(this.booking);
  const user = this.token.getUser();
  this.booking.playerId = user.id;
  this.authService.booking(this.booking).subscribe(
    data => {
      this.tmp = data;
      alert(this.tmp.body);
      f.resetForm();
    }
  )
  }
}
