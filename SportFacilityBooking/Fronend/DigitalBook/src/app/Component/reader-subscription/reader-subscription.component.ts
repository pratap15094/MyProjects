import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/entity/Book';
import { BookInfo } from 'src/app/entity/BookInfo';
import { SubscribeEntity } from 'src/app/entity/SubscribeEntity';
import { SubscriptionService } from 'src/app/service/subscription.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-reader-subscription',
  templateUrl: './reader-subscription.component.html',
  styleUrls: ['./reader-subscription.component.css']
})
export class ReaderSubscriptionComponent implements OnInit {

  userId:number;
  bookId:number;
  subscriptionId:number;
  message:string;
  errorMessage='';
  constructor(private router:Router,private userService: UserService,private tokenStorage:TokenStorageService,private subscriptionService:SubscriptionService) { }
  books:Book[] = [];
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
      observable.subscribe((response:any) => {
        this.message = String(response);
      
      })
    },
    err => {
      this.errorMessage=err.error.message;
    })
    
      alert("Please check for Subscription Status!");
      this.router.navigate(['readerdashboard']);
  }

  readBook(b:Book){
    console.log("bookContent");
    window.open(String(b.bookContent),"_blank");
    
  }
}
