import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/entity/Book';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-author-blockbook',
  templateUrl: './author-blockbook.component.html',
  styleUrls: ['./author-blockbook.component.css']
})
export class AuthorBlockbookComponent implements OnInit {
  books:Book[]=[];
  constructor(private userservice:UserService,private tokenStorage:TokenStorageService) { }

  ngOnInit(): void {
    const promise =  this.userservice.getAllBlockedBooksByUser(Number(this.tokenStorage.getUser().id));
    promise.subscribe((response)=>{
      this.books = response as Book[];
    })
  }

}
