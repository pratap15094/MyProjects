import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/service/token-storage.service';

@Component({
  selector: 'app-guest-navbar',
  templateUrl: './guest-navbar.component.html',
  styleUrls: ['./guest-navbar.component.css']
})
export class GuestNavbarComponent implements OnInit {

  username: string;
  constructor(private tokenStorage: TokenStorageService, private router: Router) { }
  book: any;
  ngOnInit(): void {
    const user = this.tokenStorage.getUser();
    this.username = user.username;
  }
  logout(): void {
    this.tokenStorage.signOut();
    window.location.reload();
  }

  saveQueryToSessionStorage(f: NgForm) {
    sessionStorage.setItem("query", String(this.book));
    this.router.navigate(['guestdashboard/search']);
    f.resetForm();
  }
  onselected(value: string) {
    sessionStorage.setItem("type", value);
  }
}
