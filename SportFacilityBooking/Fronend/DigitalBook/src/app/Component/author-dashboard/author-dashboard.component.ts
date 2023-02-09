import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/entity/Book';
import { BookInfo } from 'src/app/entity/BookInfo';
import { AuthorService } from 'src/app/service/author.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-author-dashboard',
  templateUrl: './author-dashboard.component.html',
  styleUrls: ['./author-dashboard.component.css']
})
export class AuthorDashboardComponent implements OnInit {

  content?: string;
  books:BookInfo[] = [];
  isLoggedIn = false;
  constructor(private userService: UserService,private authorService:AuthorService, private tokenStorage: TokenStorageService, private router: Router) { }
 authorName:string;
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

    this.authorService.getAuthorIdbyName(this.tokenStorage.getUser().username)
    .subscribe(data => {
      this.authorName = String(data);
      console.log(this.authorName);
      sessionStorage.setItem("authorId",String(data));
    })
  }

}
