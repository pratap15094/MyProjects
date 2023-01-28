import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Book } from 'src/app/entity/Book';
import { BookDto } from 'src/app/entity/BookDto';
import { AuthorService } from 'src/app/service/author.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';

@Component({
  selector: 'app-author-create-book',
  templateUrl: './author-create-book.component.html',
  styleUrls: ['./author-create-book.component.css']
})
export class AuthorCreateBookComponent implements OnInit {
  book = new Book();
  constructor(private authorService:AuthorService,private tokenStorage: TokenStorageService) { }
  bookLogo:string="https://th.bing.com/th/id/OIP.y-Llu8GN_V3J7e1YYGST0AHaHa?w=184&h=184&c=7&r=0&o=5&pid=1.7";
  authorId:number;
  Created:string;
bookName:string;
authorName:string;
  onSubmit(f:NgForm){
    console.log(this.book);
    this.bookLogo = String(this.book.bookLogo);
    console.log(this.tokenStorage.getUser().id);
    this.authorService.createBook(this.book,Number(sessionStorage.getItem("authorId")))
    .subscribe(data => {
      this.bookName = data;
      alert("Book "+this.bookName+" Created Successfully!");
    })
    f.resetForm();
    this.Created = "Created!";
  }
  // imgCheck(){
  //   this.bookLogo = String(this.book.bookLogo);
  // }
  ngOnInit(): void {
  }
}
