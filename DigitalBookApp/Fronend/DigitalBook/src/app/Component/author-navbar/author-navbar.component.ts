import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/service/token-storage.service';

@Component({
  selector: 'app-author-navbar',
  templateUrl: './author-navbar.component.html',
  styleUrls: ['./author-navbar.component.css']
})
export class AuthorNavbarComponent implements OnInit {

  username:string;
  book:any;
  constructor(private tokenStorage:TokenStorageService,private router:Router) { }

  ngOnInit(): void {
    const user = this.tokenStorage.getUser();
    this.username = user.username;
  }
  logout(): void {
    this.tokenStorage.signOut();
    window.location.reload();
  }

  saveQueryToSessionStorage(f:NgForm){
    sessionStorage.setItem("query",String(this.book));
    this.router.navigate(['authordashboard/search']);
    f.resetForm();
  }
  onselected(value:string){
    sessionStorage.setItem("type",value);
  }
}
