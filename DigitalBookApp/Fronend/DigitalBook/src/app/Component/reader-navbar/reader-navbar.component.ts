import { Token } from '@angular/compiler/src/ml_parser/tokens';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/service/token-storage.service';

@Component({
  selector: 'app-reader-navbar',
  templateUrl: './reader-navbar.component.html',
  styleUrls: ['./reader-navbar.component.css']
})
export class ReaderNavbarComponent implements OnInit {
  selectValue:string;
  username:string;
  constructor(private tokenStorage:TokenStorageService,private router:Router) { }

  ngOnInit(): void {
    this.selectValue = "Title";
    const user = this.tokenStorage.getUser();
    this.username = user.username;
  }
  logout(): void {
    this.tokenStorage.signOut();
    window.location.reload();
  }
  book:any;
  saveQueryToSessionStorage(f:NgForm){
    sessionStorage.setItem("query",String(this.book));
    this.router.navigate(['readerdashboard/search']);
    f.resetForm();
  }
  
  onselected(value:string){
    this.selectValue = value
    sessionStorage.setItem("type",this.selectValue);
  }
}
