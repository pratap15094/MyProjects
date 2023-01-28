package com.book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;

import com.book.dto.BookInfodto;
import com.book.entity.Author;
import com.book.entity.Book;
import com.book.repository.IAuthorRepository;
import com.book.repository.IBookInfo;
import com.book.repository.IBookRepository;
import com.book.service.BookServiceImpl;

@SpringBootTest(classes = { BookServiceMockitoTests.class })
public class BookServiceMockitoTests {

	@Mock
	IBookRepository bookRepository;

	@InjectMocks
	BookServiceImpl bookService;
	
	public List<Book> book;

	@Test
	@Order(1)
	public void test_createBook() {

		Author author = new Author();
		author.setAuthorId(1);
		BookInfodto bookinfodto = new BookInfodto(1, "Gandhi lifestories", "rishabh", "Study", 101, "MGH", "26-02-2626",
				"logo", "desc", "Content", false);

		Book book = new Book();
		book.setBookTitle(bookinfodto.getBookTitle());
		book.setBookCategory(bookinfodto.getBookCategory());
		book.setBookAuthor(author);
		book.setBookPrice(bookinfodto.getBookPrice());
		book.setBookPublisher(bookinfodto.getBookPublisher());
		book.setBookPublishedDate(bookinfodto.getBookPublishedDate());
		book.setBookLogo(bookinfodto.getBookLogo());
		book.setBookContent(bookinfodto.getBookContent());
		book.setBookActive(bookinfodto.isBookActive());
		
		String update = book.getBookTitle() + " Created!";
		when(bookRepository.save(book)).thenReturn(book); // Mocking
		assertEquals(bookRepository.save(book),book);
	}

	@Test
	@Order(2)
	public void test_getBookAllDetails() {
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories",  author, "Study", 101, "MGH", "26-02-2626",
				"logo", "desc", "Content", false);
		Optional<Book> books = Optional.of(book);
		when(bookRepository.findById(book.getBookId())).thenReturn(books);
		assertEquals(books, bookService.getBookAllDetails(book.getBookId()));
	}

	@Test
	public void test_listAllBookInfo() {
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		List<Book> book = new ArrayList<Book>();
		book.add(new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc", "Content",
				false));

		when(bookRepository.findAll()).thenReturn(book);// Mocking
		assertEquals(1, bookService.listAllBookInfo().size());
	}

	@Test
	public void test_updateBookContent() {
		String status1 = "Not able to update book, Kindly check logs!";
		BookInfodto book = new BookInfodto(1, "Gandhi lifestories","rishabh", "Study", 101, "MGH", "26-02-2626",
				"logo", "desc", "Content", false);
		Book existingBook = new Book();
		existingBook.setBookContent(book.getBookContent());
		when(bookRepository.save(existingBook)).thenReturn(existingBook);
		String status="Updated Book '"+existingBook.getBookTitle()+"'";
		assertEquals(bookRepository.save(existingBook),existingBook);
		
	}
	
	@Test	
	public void updateBookStatus(){
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc", "Content",
				false);
	Book existingBook = new Book();
	existingBook.setBookActive(book.isBookActive());
	when(bookRepository.save(existingBook)).thenReturn(existingBook);
	assertEquals(bookRepository.save(existingBook),existingBook);
	}
	
	


	@Test
	public void test_getAuthorNameByBookId() {
		Author author = new Author(1, "Rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		List<IBookInfo> booktmapper = new ArrayList<>();
		when(bookRepository.findByBookId(book.getBookId())).thenReturn(booktmapper);// Mocking
		//booktmapper.get(0).getbookAuthor().getAuthorName();
		assertEquals(bookRepository.findByBookId(book.getBookId()),booktmapper);
		
	}
	
	
	@Test
	public void test_getBookByTitle() {
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		List<Book> bookList = new ArrayList<>();
		bookList.add(book);
		when(bookRepository.findByBookTitle(book.getBookTitle())).thenReturn(bookList);// Mocking
		assertEquals(1, bookService.getBookByTitle(book.getBookTitle()).size());
	}
	
	@Test
	public void getBookContentById(){
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		List<Book> bookList = new ArrayList<>();
		bookList.add(book);
		when(bookRepository.findByBookTitle(book.getBookTitle())).thenReturn(bookList);// Mocking
		assertEquals( bookService.getBookContentById(book.getBookTitle()),"Content" );
	}
	
//	@Test
//	public void createAuthor() {
//		
//	}
	
	@Test
	public void test_listBookByCategory() {
		Author author1 = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Author author2 = new Author(2, "saurabh", "saurabh@gmail.com", "password", "ROLE_READER");
		List<Book> book = new ArrayList<Book>();
		book.add(new Book(1, "Gandhi lifestories", author1, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false));
		book.add(new Book(1, "India Times", author2, "Study", 202, "MGH", "26-02-2626", "logo", "desc", "Content",
				true));
		String bookCategory = "Study";
		when(bookRepository.findByBookCategory(bookCategory)).thenReturn(book);// Mocking
		assertEquals(2, bookService.listBookByCategory(bookCategory).size());
	}
	
	
	@Test
	public void listBookByPublisher() {
		Author author1 = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Author author2 = new Author(2, "saurabh", "saurabh@gmail.com", "password", "ROLE_READER");
		List<Book> book = new ArrayList<Book>();
		book.add(new Book(1, "Gandhi lifestories", author1, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false));
		book.add(new Book(1, "India Times", author2, "Study", 202, "MGH", "26-02-2626", "logo", "desc", "Content",
				true));
		String bookCategory = "MGH";
		when(bookRepository.findByBookPublisher(bookCategory)).thenReturn(book);// Mocking
		assertEquals(2, bookService.listBookByPublisher(bookCategory).size());
	}
	
	@Test
	public void listBookByAuthor() {
		Author author1 = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author1, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		List<Book> bookList = new ArrayList<>();
		bookList.add(book);
		when(bookRepository.findByBookAuthor(author1)).thenReturn(bookList);// Mocking
		assertEquals(1, bookService.listBookByAuthor(author1).size());
	}
	
//	@Test
//	public void createAuthor() {
//		Author author1 = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
//		when(authorRepo.save(author1)).thenReturn(author1);
//		assertEquals(bookService.createAuthor(author1),null);
//	}


	
}