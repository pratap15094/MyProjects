import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookInfo } from 'src/app/entity/BookInfo';
import { SubscribeEntity } from 'src/app/entity/SubscribeEntity';
import { AuthorService } from 'src/app/service/author.service';
import { SubscriptionService } from 'src/app/service/subscription.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { UserService } from 'src/app/service/user.service';


@Component({
  selector: 'app-author-home',
  templateUrl: './author-home.component.html',
  styleUrls: ['./author-home.component.css']
})
export class AuthorHomeComponent implements OnInit {
  userId:number;
  bookId:number;
  errorMessage='';
  authorName:string;
  constructor(private userService: UserService,private authorService:AuthorService, private tokenStorage: TokenStorageService, private router: Router,private subscriptionService:SubscriptionService) { }
  books:BookInfo[] = [];
  checkBook:BookInfo[]=[];
  subscriberObj = new SubscribeEntity();
  message:string;
  ngOnInit(): void {
    
    const promise = this.userService.getAllBook();
      promise.subscribe( (response) => {
          this.books = response as BookInfo[];
        });
  }
 
  subscribeEntity = new SubscribeEntity();
  
  subscribeMethod(book:BookInfo){
     this.userId= this.tokenStorage.getUser().id;
     console.log(this.userId);
     console.log(book.bookId);
     this.subscribeEntity.userId = this.userId;
     this.subscribeEntity.bookId = book.bookId;
     this.subscriptionService.subscribeBook(this.subscribeEntity)
     .subscribe(data =>{
       if(data === null){
        alert("Already Subscribed");
       }
       else
       {
       alert("Subscribed successfully, Subscription Id "+data);
       }
     },
     err => {
      this.errorMessage = err.error.message;
      alert("Subscription failed");
     }
     )
  }
 
}
