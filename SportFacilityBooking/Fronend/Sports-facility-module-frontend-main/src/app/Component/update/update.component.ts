import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserDto } from 'src/app/entity/UserDto';
import { LoginService } from 'src/app/services/login.service';

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
  errorMessage = '';

  constructor(private authService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }
  onSubmit(f: NgForm): void {

    // console.log(this.register.role)
    // console.log(this.register.username);
    this.authService.register(this.update).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        f.resetForm();
        alert("Details Update Successfully!");
       this.router.navigate(['/login'])
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}
