import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/entity/Book';
import { BookInfo } from 'src/app/entity/BookInfo';
import { SubscribeEntity } from 'src/app/entity/SubscribeEntity';
import { AuthorService } from 'src/app/service/author.service';
import { SearchService } from 'src/app/service/search.service';
import { SubscriptionService } from 'src/app/service/subscription.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-author-search',
  templateUrl: './author-search.component.html',
  styleUrls: ['./author-search.component.css']
})
export class AuthorSearchComponent implements OnInit {
  books:BookInfo[]=[];
  constructor(private authorService:AuthorService,private searchService:SearchService,private userService: UserService, private tokenStorage: TokenStorageService,private subscriptionService:SubscriptionService) { }
  searchType:string;
  message:string;
  ngOnInit(): void {
    this.searchType = sessionStorage.getItem("type");
    if(this.searchType === "Title"){
    console.log(sessionStorage.getItem('query'));
    const promise = this.searchService.getBookByTitle(sessionStorage.getItem('query'));
    promise.subscribe((response) => {
      console.log(response);
      this.books = response as BookInfo[];
    })
  }
  else if(this.searchType === "Category")
  {
    const promise = this.searchService.getBookByCategory(sessionStorage.getItem('query'));
    promise.subscribe((response) => {
      this.books = response as BookInfo[];
    })
  
  }
  else if(this.searchType === "Publisher")
  {
    const promise = this.searchService.getBookByPublisher(sessionStorage.getItem('query'));
    promise.subscribe((response) => {
      this.books = response as BookInfo[];
    })
  }
  else
  {
    this.message = "No Book Found!";
  }
  }
  alertMethod(){
    alert("Refer My Books to read!");
  }
  subscribeEntity = new SubscribeEntity();
  userId:number;
  errorMessage:string;
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
       else{
       alert("Subscribed successfully, Subscription Id "+data);
       }
     },
     err => {
      this.errorMessage = err.error.message;
      alert("Subscription failed");
     }
     )
  }
  subscribe = new SubscribeEntity();
  blockBook(b:BookInfo){
    this.subscribe.bookId = b.bookId;
    this.subscribe.userId = Number(this.tokenStorage.getUser().id);
    this.authorService.blockBookByUserIdBookId(this.subscribe)
    .subscribe((Response)=>{
      alert("Book Blocked! "+Response);
    })
    alert("Book Blocked! ");
  }
}
