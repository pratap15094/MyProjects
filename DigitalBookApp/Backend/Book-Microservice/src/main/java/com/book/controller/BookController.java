package com.book.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.dto.BookInfodto;
import com.book.entity.Author;
import com.book.entity.Book;
import com.book.repository.IAuthorRepository;
import com.book.repository.IBookInfo;
import com.book.repository.IBookRepository;
import com.book.service.IBookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private IBookService bookService;
	
	@Autowired
	private IBookRepository bookRepo;
	
	@Autowired
	private BookInfodto bookInfodto;
	
	@Autowired
	private IAuthorRepository authorRepo;
	
	@PostMapping("/createBook/{authorId}")
	public String createBook(@PathVariable int authorId,@RequestBody BookInfodto book)
	{
		String bookName = bookService.createBook(book,authorId);
		System.out.println(bookName);
		return bookName;
	}
	
	@GetMapping("/getAllBookDetails/{bookId}")
	public Optional<Book> getBookByAllDetails(@PathVariable Integer bookId){
		Optional<Book> book = bookService.getBookAllDetails(bookId);
		return book;
	}
	
	@GetMapping("/getBookInfo/{bookId}")
	public List<BookInfodto> getBookInfo(@PathVariable Integer bookId){
		 BookInfodto book = new BookInfodto();
	     List<IBookInfo> bookList = bookRepo.findByBookId(bookId);
	     IBookInfo bookInfo = bookList.get(0);
	     book.setBookId(bookInfo.getbookId());
	     book.setBookTitle(bookInfo.getBookTitle());
	     book.setBookAuthor(bookInfo.getbookAuthor().getAuthorName());
	     book.setBookCategory(bookInfo.getbookCategory());
	     book.setBookDescription(bookInfo.getbookDescription());
	     book.setBookLogo(bookInfo.getbookLogo());
	     book.setBookPrice(bookInfo.getbookPrice());
	     book.setBookPublisher(bookInfo.getbookPublisher());
	     book.setBookPublishedDate(bookInfo.getbookPublishedDate());
	     List<BookInfodto> booktmp = new ArrayList<>();
	     booktmp.add(book);
	     return booktmp;
	}
	
	@GetMapping("/allBooks")
	public List<Book> listAllBooksInfo(){
		
		List<Book> bookList = bookService.listAllBookInfo();	
		return bookList;
	}
	
	@PutMapping("/updateBook/{id}")
	public String updateBookByAuthor(@PathVariable("id") Integer id, @RequestBody BookInfodto book) {
		return bookService.updateBookContent(book, id);
	}
	
	@PatchMapping("/changeActiveStatus/{id}")
	public ResponseEntity<Book> updateBookStatus(@PathVariable("id") Integer id,@RequestBody Book book ){
		return new ResponseEntity<Book>(bookService.updateBookStatus(book, id),HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public List<Book> getBookByCategoryTitleAuthorPricePublisher(
			@RequestParam String bookCategory,
			@RequestParam String bookTitle,
			@RequestParam int bookPrice,
			@RequestParam String bookPublisher)
	{
		return bookRepo.findByBookCategoryAndBookTitleAndBookPriceAndBookPublisher(bookCategory, bookTitle,bookPrice, bookPublisher);
	}
	
	@GetMapping("/searchbycategory/{bookCategory}")
	public List<Book> getBookByCategory(@PathVariable String bookCategory){
		
	     List<Book> bookList = bookService.listBookByCategory(bookCategory);
	     return bookList;
	}
	
	@GetMapping("/getauthorname/{bookId}")
	public String getBookAuthor(@PathVariable int bookId) {
		String authorName = bookService.getAuthorNameByBookId(bookId);
		return authorName;
	}
	
	@GetMapping("/title/{bookTitle}")
	public List<Book> getBookByTitle(@PathVariable String bookTitle){
		
	     List<Book> bookList = bookService.getBookByTitle(bookTitle);
	     return bookList;
	}
	
	@GetMapping("/getbookContent/{bookTitle}")
	public String getBookContentByTitle(@PathVariable String bookTitle) {
		return bookService.getBookContentById(bookTitle);
	}
	
	@PostMapping("/addauthor")
	public ResponseEntity<?> addAuthor(@RequestBody Author author){
		 bookService.createAuthor(author);
		 return ResponseEntity.ok("Author registered with book service!->C");
	}
	@GetMapping("/getbookid/{bookTitle}")
	public Integer getBookIdByTitleUpdate(@PathVariable String bookTitle){
		
	     List<Book> bookList = bookService.getBookByTitle(bookTitle);
	     Integer id = bookList.get(0).getBookId();
	     return id;
	}
	
	@GetMapping("/getauthoridbyname/{name}")
	public Integer getAuthorIdByName(@PathVariable String name) {
		List<Author> author = authorRepo.findByAuthorName(name);
		Integer id = author.get(0).getAuthorId();
		return id;
	}
	
	@GetMapping("/searchbypublisher/{bookPublisher}")
	public List<Book> searchBuPublisher(@PathVariable String bookPublisher){
		List<Book> book = bookService.listBookByPublisher(bookPublisher);
		return book;
	}
	
	@GetMapping("/getbooklistbyauthor/{id}")
	public List<Book> getBooksByAuthor(@PathVariable int id){
		Author author = new Author();
		author.setAuthorId(id);
		List<Book> book = bookService.listBookByAuthor(author);
		return book;
	}
}
