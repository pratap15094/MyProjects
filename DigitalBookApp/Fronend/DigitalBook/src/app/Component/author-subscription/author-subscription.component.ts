import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/entity/Book';
import { BookInfo } from 'src/app/entity/BookInfo';
import { SubscribeEntity } from 'src/app/entity/SubscribeEntity';
import { AuthorService } from 'src/app/service/author.service';
import { SubscriptionService } from 'src/app/service/subscription.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-author-subscription',
  templateUrl: './author-subscription.component.html',
  styleUrls: ['./author-subscription.component.css']
})
export class AuthorSubscriptionComponent implements OnInit {
  userId:number;
  bookId:number;
  subscriptionId:number;
  message:string;
  errorMessage='';
  constructor(private authorService:AuthorService,private router:Router,private userService: UserService,private tokenStorage:TokenStorageService,private subscriptionService:SubscriptionService) { }
  books:Book[] = [];
  createdBooks:Book[] = [];
  ngOnInit(): void {
    console.log(this.tokenStorage.getUser().id);
    const promise = this.subscriptionService.getSubscribedBook(this.tokenStorage.getUser().id);
    promise.subscribe((response) => {
      this.books = response as Book[];
      console.log(this.books);
    });

    
  }
  subscribeEntity = new SubscribeEntity();
  unsubscribeMethod(book:BookInfo){
    this.userId= this.tokenStorage.getUser().id;
    console.log(this.userId);
    console.log(book.bookId);
    this.subscribeEntity.userId = this.userId;
    this.subscribeEntity.bookId = book.bookId;
    this.subscriptionService.getSubscriptionId(this.subscribeEntity)
    .subscribe(data => {
      this.subscriptionId=Number(data);
      console.log("subsId",this.subscriptionId);
      const observable = this.subscriptionService.unsubscribeBook(this.subscriptionId);
      observable.subscribe((response:string) => {
        this.message = response;
        alert("Book Unsubscribed, Check Email");
        window.location.reload();
      })
    },
    err => {
      this.errorMessage=err.error.message;
      alert("Unsubscription Failed after 24hrs ");
    })
    alert("Please check mail for Subscription status!");
    this.router.navigate(['authordashboard']);
  }

  readBook(b:Book){
    console.log("bookContent");
    window.open(String(b.bookContent),"_blank");
    
  }
  
}
