import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './services/login.service';
import { TokenStorageService } from './services/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {

  private roles: string[] = [];
  isLoggedIn = false;
  isRole = false;


  constructor(private authService: LoginService, private tokenStorageService: TokenStorageService, private router: Router) { }


  title = 'sportsfacility';

  ngOnInit() {
    this.isLoggedIn = !!this.tokenStorageService.getToken(); if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      this.isRole = this.roles.includes('ROLE_GUEST');
      if (this.isRole == true) {
        this.router.navigate(['dashboard']);
      };
    }

  }

}
