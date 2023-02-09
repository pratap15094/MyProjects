import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Book } from 'src/app/entity/Book';
import { AuthorService } from 'src/app/service/author.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';

@Component({
  selector: 'app-author-update-book',
  templateUrl: './author-update-book.component.html',
  styleUrls: ['./author-update-book.component.css']
})
export class AuthorUpdateBookComponent implements OnInit {
  book = new Book();
  bookName:string="";
  constructor(private authorService:AuthorService,private tokenStorage:TokenStorageService) { }

  ngOnInit(): void {
  }
 authorId:number;
 bookId:number;
 authorName:string
  onSubmit(f:NgForm){
    // this.authorService.getbookIdbyTitle(String(this.book.bookTitle))
    // .subscribe(data=>{
      
    //   this.bookId = Number(data);;
    //   console.log("-----------------"+this.book.bookId);
      
    // })
    // this.authorName = this.tokenStorage.getUser().username;

    // this.authorService.getAuthorIdbyName(this.authorName)
    // .subscribe((data:any) => {
    //   console.log(data);
    //   this.authorId = Number(data);
    // })
    // console.log("authorname"+this.authorId);
    
    // //console.log("-----------------"+this.bookId);
    // console.log(this.book.bookId);
    // this.authorService.getAuthorNameByBookId(this.book.bookId)
    // .subscribe(data => {
    //   this.authorName = String(data);
    //   console.log(this.authorName);
    // })
  
    console.log(this.book.bookId);
    this.authorService.updateBook(this.book,this.book.bookId)
    .subscribe(data=>{
      this.bookName = data;
      alert("Book "+this.bookName+" Updated!");
    })
    console.log(this.book);
    f.resetForm();
  }

}
