import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';
import { RegisterUser } from 'src/app/entity/registerUser';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  register = new RegisterUser();
  // form: any = {
  //   username: null,
  //   email: null,
  //   password: null,
  // };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  

  constructor(private authService: LoginService) { }

  ngOnInit(): void {
  }
  onSubmit(f:NgForm): void {
    
    console.log(this.register.role)
    console.log(this.register.username);
    this.authService.register(this.register).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        f.resetForm();
        alert(" Registered Successfully!");
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
   
  
  }
}