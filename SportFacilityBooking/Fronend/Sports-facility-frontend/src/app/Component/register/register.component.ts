import { Component, OnInit } from '@angular/core';
import { FormBuilder, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/entity/User';
import { LoginService } from 'src/app/services/login.service';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  register = new User();

  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: LoginService, private router: Router) { }


  ngOnInit(): any {

  }

  onSubmit(f: NgForm): void {

    this.authService.register(this.register).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        f.resetForm();
        alert("Registered Successfully!");
        this.router.navigate(['/login'])
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}