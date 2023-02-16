import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/entity/User';
import { UserDto } from 'src/app/entity/UserDto';
import { BookingService } from 'src/app/services/booking.service';
import { LoginService } from 'src/app/services/login.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  // constructor() { }

  // ngOnInit(): void {
  // }

  update = new UserDto();
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage: string;

  constructor(private authService: BookingService, private router: Router,private tokenstorage:TokenStorageService) { }

  ngOnInit(): void {
  }
  onSubmit(f: NgForm): void {
    console.log(this.update);
    const temp = this.tokenstorage.getUser();
    this.update.username=temp.username;
    this.authService.updateUser(this.update).subscribe(
      data => {
        this.errorMessage = data;
      })
    alert("Updated " + this.update.username);
    f.resetForm();
  }
}
