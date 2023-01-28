import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/entity/Book';
import { AuthorService } from 'src/app/service/author.service';
import { SubscriptionService } from 'src/app/service/subscription.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { UserService } from 'src/app/service/user.service';
import { CommonModule } from "@angular/common";
@Component({
  selector: 'app-author-mybooks',
  templateUrl: './author-mybooks.component.html',
  styleUrls: ['./author-mybooks.component.css']
})
export class AuthorMybooksComponent implements OnInit {

  constructor(private authorService:AuthorService,private router:Router,private userService: UserService,private tokenStorage:TokenStorageService,private subscriptionService:SubscriptionService) { }
  books:Book[] = [];
  id:number;
  ngOnInit(): void {
    const promiseauthor = this.authorService.getBookListByAuthorId(Number(sessionStorage.getItem("authorId")));
    promiseauthor.subscribe((response) =>{
      this.books = response as Book[];
      console.log(this.books);
    });
  }

  readBook(b:Book){
    console.log("bookContent");
    window.open(String(b.bookContent),"_blank");
    
  }
  

}
