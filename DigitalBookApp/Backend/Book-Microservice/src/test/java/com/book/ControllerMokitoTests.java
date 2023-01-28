package com.book;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.controller.BookController;
import com.book.dto.BookInfodto;
import com.book.entity.Author;
import com.book.entity.Book;
import com.book.repository.IBookInfo;
import com.book.repository.IBookRepository;
import com.book.service.BookServiceImpl;

@SpringBootTest(classes = { ControllerMokitoTests.class })
public class ControllerMokitoTests {

	@Mock
	BookServiceImpl bookService;

	@Mock
	IBookRepository bookRepository;

	@InjectMocks
	BookController bookController;

	public List<Book> book;

	@Test
	@Order(1)
	public void test_createBook() {

		BookInfodto book = new BookInfodto(1, "Gandhi lifestories", "rishabh", "Study", 101, "MGH", "26-02-2626",
				"logo", "desc", "Content", false);
		when(bookService.createBook(book, 1)).thenReturn(book.getBookTitle());
		assertEquals(book.getBookTitle(), bookController.createBook(1, book));
	}

	@Test
	@Order(2)
	public void test_getBookByAllDetails() {

		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		Optional<Book> getbook = bookService.getBookAllDetails(1);
		when(bookService.getBookAllDetails(1)).thenReturn(getbook);
		assertEquals(getbook, bookController.getBookByAllDetails(1));
	}

//	@Test
//	@Order(3)
//	public void test_getBookInfo() {
//
//		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
//		IBookInfo bookInfo = new IBookInfo(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
//				"Content", false);
//		BookInfodto book = new BookInfodto();
//
//		book.setBookId(bookInfo.getbookId());
//		book.setBookTitle(bookInfo.getBookTitle());
//		book.setBookAuthor(bookInfo.getbookAuthor().getAuthorName());
//		book.setBookCategory(bookInfo.getbookCategory());
//		book.setBookDescription(bookInfo.getbookDescription());
//		book.setBookLogo(bookInfo.getbookAuthor());
//		book.setBookPrice(bookInfo.getBookPrice());
//		book.setBookPublisher(bookInfo.getBookPublisher());
//		book.setBookPublishedDate(bookInfo.getBookPublishedDate());
//		
//		
//		List<IBookInfo> booktmp = new ArrayList<>();
//		booktmp.add(bookInfo);
//		when(bookRepository.findByBookId(1)).thenReturn(booktmp);
//
//		assertEquals(1, bookController.getBookInfo(1).size());
//	}

	@Test
	@Order(4)
	public void test_listAllBookInfo() {
		List<Book> book = new ArrayList<Book>();
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		book.add(new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc", "Content",
				false));
		when(bookService.listAllBookInfo()).thenReturn(book);
		assertEquals(1, bookController.listAllBooksInfo().size());
	}

	@Test
	@Order(5)
	public void test_updateBookByAuthor() {
		String status1 = "Not able to update book, Kindly check logs!";
		BookInfodto book = new BookInfodto(1, "Gandhi lifestories", "rishabh", "Study", 101, "MGH", "26-02-2626",
				"logo", "desc", "Content", false);
		String status2 = "Updated Book '" + book.getBookTitle() + "'";
		when(bookService.updateBookContent(book, 1)).thenReturn(status1);
		assertEquals(status1, bookController.updateBookByAuthor(1, book));
		when(bookService.updateBookContent(book, 1)).thenReturn(status2);
		assertEquals(status2, bookController.updateBookByAuthor(1, book));
	}

	@Test
	@Order(6)
	public void test_updateBookStatus() {
		List<Book> bookList = new ArrayList<>();
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		bookList.add(book);
		when(bookService.updateBookStatus(book, 1)).thenReturn(book);

		ResponseEntity<Book> res = bookController.updateBookStatus(1, book);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(1, res.getBody().getBookId());
	}

	@Test
	@Order(7)
	public void test_getBookByCategoryTitleAuthorPricePublisher() {
		List<Book> bookList = new ArrayList<>();
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		bookList.add(book);

		when(bookRepository.findByBookCategoryAndBookTitleAndBookPriceAndBookPublisher(book.getBookCategory(),
				book.getBookTitle(), book.getBookPrice(), book.getBookPublisher())).thenReturn(bookList);
		List<Book> books = bookController.getBookByCategoryTitleAuthorPricePublisher(book.getBookCategory(),
				book.getBookTitle(), book.getBookPrice(), book.getBookPublisher());
		assertEquals(1, books.size());
	}

	@Test
	@Order(8)
	public void test_getBookByCategory() {
		List<Book> bookList = new ArrayList<>();
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		bookList.add(book);
		when(bookService.listBookByCategory(book.getBookCategory())).thenReturn(bookList);
		assertEquals(1, bookList.size());
	}

	@Test
	@Order(9)
	public void test_getBookAuthor() {
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		when(bookService.getAuthorNameByBookId(book.getBookId())).thenReturn(author.getAuthorName());
		assertEquals("rishabh", bookController.getBookAuthor(book.getBookId()));
	}

	@Test
	@Order(10)
	public void test_getBookByTitle() {

		List<Book> bookList = new ArrayList<>();
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		bookList.add(book);

		when(bookService.getBookByTitle(book.getBookTitle())).thenReturn(bookList);
		List<Book> books = bookController.getBookByTitle(book.getBookTitle());
		assertEquals(1, books.size());
	}

	@Test
	@Order(11)
	public void test_getBookContentByTitle() {

		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);

		when(bookService.getBookContentById(book.getBookTitle())).thenReturn(book.getBookTitle());
		assertEquals("Gandhi lifestories", bookController.getBookContentByTitle(book.getBookTitle()));
	}

	@Test
	@Order(12)
	public void test_addAuthor() {
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		ResponseEntity<?> res = new ResponseEntity<>(HttpStatus.OK);
		when(bookService.createAuthor(author)).thenReturn(null);// Mocking
		assertEquals(bookController.addAuthor(author),ResponseEntity.ok("Author registered with book service!->C"));
	}

}
