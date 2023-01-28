import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/entity/Book';
import { BookInfo } from 'src/app/entity/BookInfo';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-guest-dashboard',
  templateUrl: './guest-dashboard.component.html',
  styleUrls: ['./guest-dashboard.component.css']
})
export class GuestDashboardComponent implements OnInit {

  content?: string;
  books:BookInfo[] = [];
  isLoggedIn = false;
  constructor(private userService: UserService, private tokenStorage: TokenStorageService, private router: Router) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorage.getToken();
    if (this.isLoggedIn) {
      this.userService.getUserBoard().subscribe(
        data => {

          this.content = data;
        },
        err => {
          this.content = JSON.parse(err.error).message;
        }
      );
    
    }
    else {
      this.router.navigate(['']);
    }
  }

}
