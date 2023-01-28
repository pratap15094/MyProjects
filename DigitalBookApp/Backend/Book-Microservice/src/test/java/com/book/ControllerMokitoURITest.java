package com.book;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.book.controller.BookController;
import com.book.dto.BookInfodto;
import com.book.entity.Author;
import com.book.entity.Book;
import com.book.service.BookServiceImpl;


@TestMethodOrder(OrderAnnotation.class)
@ComponentScan(basePackages = "com.book")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes = { ControllerMokitoURITest.class })
public class ControllerMokitoURITest {

	@Autowired
	MockMvc mockMvc;

	@Mock
	BookServiceImpl bookService;

	@InjectMocks
	BookController bookController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	}

	@Test
	@Order(1)
	public void test_createBook() throws Exception {
		BookInfodto book = new BookInfodto(1, "Gandhi lifestories", "rishabh", "Study", 101, "MGH", "26-02-2626",
				"logo", "desc", "Content", false);
		when(bookService.createBook(book, 1)).thenReturn(book.getBookTitle());
		this.mockMvc.perform(post("/createBook/{authorId}", 1)).andReturn();
	}

	@Test
	@Order(2)
	public void test_getBookByAllDetails() throws Exception {

		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		Optional<Book> getbook = bookService.getBookAllDetails(book.getBookId());
		when(bookService.getBookAllDetails(1)).thenReturn(getbook);
		this.mockMvc.perform(get("/getAllBookDetails/{bookId}", 1)).andReturn();
	}
	
	
	@Test
	@Order(4)
	public void getBookInfo() {
		
	}
	
	@Test
	@Order(4)
	public void test_listAllBookInfo() throws Exception {
		List<Book> book = new ArrayList<Book>();
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		book.add(new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc", "Content",
				false));
		when(bookService.listAllBookInfo()).thenReturn(book);
		this.mockMvc.perform(get("/allBooks")).andReturn();
	}

	
	@Test
	@Order(5)
	public void test_updateBookByAuthor() throws Exception {
		
		BookInfodto book = new BookInfodto(1, "Gandhi lifestories", "rishabh", "Study", 101, "MGH", "26-02-2626",
				"logo", "desc", "Content", false);
		String status = "Updated Book '" + book.getBookTitle() + "'";
		when(bookService.updateBookContent(book, 1)).thenReturn(status);
		this.mockMvc.perform(put("/updateBook/{id}", 1))
		.andReturn();
		
	}
	
	@Test
	@Order(6)
	public void test_updateBookStatus() throws Exception {
		List<Book> bookList = new ArrayList<>();
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		bookList.add(book);
		when(bookService.updateBookStatus(book, 1)).thenReturn(book);
		this.mockMvc.perform(put("/changeActiveStatus/{id}", 1))
		.andReturn();
	}
	
	@Test
	@Order(6)
	public void test_getBookByCategoryTitleAuthorPricePublisher() throws Exception{
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		Optional<Book> getbook = bookService.getBookAllDetails(book.getBookId());
		when(bookService.getBookAllDetails(1)).thenReturn(getbook);
		this.mockMvc.perform(get("/search")).andReturn();
	}
	
	@Test
	@Order(6)
	public void test_getBookByCategory() throws Exception {
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		List<Book> bookList = new ArrayList<>();
		when(bookService.listBookByCategory(book.getBookCategory())).thenReturn(bookList);
		this.mockMvc.perform(get("/searchbycategory/{bookCategory}", "Study"))
		.andReturn();
	}
	
	@Test
	@Order(6)
	public void getBookAuthor() throws Exception {
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		when(bookService.getAuthorNameByBookId(1)).thenReturn(book.getBookAuthor().getAuthorName());
		this.mockMvc.perform(get("/getauthorname/{bookId}", 1))
		.andReturn();
	}
	
	@Test
	@Order(6)
	public void getBookByTitle() throws Exception {
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		List<Book> bookList = new ArrayList<>();
		bookList.add(book);
		when(bookService.getBookByTitle(book.getBookTitle())).thenReturn(bookList);
		this.mockMvc.perform(get("/title/{bookTitle}", "Study"))
		.andReturn();
	}
	
	@Test
	@Order(6)
	public void getBookContentByTitle() throws Exception {
		Author author = new Author(1, "rishabh", "rishabh@gmail.com", "password", "ROLE_AUTHOR");
		Book book = new Book(1, "Gandhi lifestories", author, "Study", 101, "MGH", "26-02-2626", "logo", "desc",
				"Content", false);
		when(bookService.getBookContentById(book.getBookTitle())).thenReturn(book.getBookContent());
		this.mockMvc.perform(get("/getbookContent/{bookTitle}", "Study"))
		.andReturn();
	}
	
	@Test
	@Order(6)
	public void addAuthor() {
		
	}
	
}