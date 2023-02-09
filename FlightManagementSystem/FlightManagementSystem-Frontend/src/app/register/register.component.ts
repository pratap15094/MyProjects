import { Component, OnInit } from '@angular/core';
import { Route, Router, Routes } from '@angular/router';
import { AuthService } from '../_service/auth.service';
import { FormsModule, NgForm } from '@angular/forms';
import { User } from '../Entity/User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  // form: any = {
  //   username: null,
  //   email: null,
  //   mobilenumber: null,
  //   pannumber: null,
  //   birthDate: null,
  //   password: null,
  //   address:null,
  //   city:null
  // };
  user = new User();

  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  constructor(private authService: AuthService, private router: Router) { }
  ngOnInit(): void {

  }
  onSubmit(f:NgForm): void {
    // const { username, email, mobilenumber, password } = this.form;
    this.authService.register(this.user).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.router.navigate(['/login'])
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}
