import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from './service/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {


  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username?: string;
  showGuest = false;
  constructor(private tokenStorageService: TokenStorageService,private router:Router) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_READER');
      this.showModeratorBoard = this.roles.includes('ROLE_AUTHOR');
      this.showGuest = this.roles.includes('ROLE_GUEST');
      if(this.showAdminBoard == true){
        this.router.navigate(['readerdashboard']);
      }
      if(this.showModeratorBoard== true){
        this.router.navigate(['authordashboard']);
      }
      if(this.showGuest){
        this.router.navigate(['guestdashboard']);
      }
      this.username = user.username;
    }
  }

  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}