import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookInfo } from 'src/app/entity/BookInfo';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-guest-home',
  templateUrl: './guest-home.component.html',
  styleUrls: ['./guest-home.component.css']
})
export class GuestHomeComponent implements OnInit {
  books:BookInfo[] = [];
  constructor(private userService: UserService, private tokenStorage: TokenStorageService, private router: Router) { }

  ngOnInit(): void {
    const promise = this.userService.getAllBook();
    promise.subscribe( (response) => {
        this.books = response as BookInfo[];
        console.log(this.books);
      });
  }

  onReadClick(){
    alert("Please register to enjoy reading!");
  }
}
