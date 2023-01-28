package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.book.dto.BookInfodto;
import com.book.entity.Author;
import com.book.entity.Book;
import com.book.exceptions.BookServiceException;
import com.book.repository.IAuthorRepository;
import com.book.repository.IBookInfo;
import com.book.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService{
	
	@Autowired
	IBookRepository bookRepository;
	
	@Autowired
	IAuthorRepository authorRepository;
	
	@Override
	public String createBook(BookInfodto book, int id) {
		Book existingBook = new Book();
		Author author = new Author();
		author.setAuthorId(id);
		System.out.println(author.getAuthorId());
		try {
			existingBook.setBookTitle(book.getBookTitle());
			existingBook.setBookActive(book.isBookActive());
			existingBook.setBookCategory(book.getBookCategory());
			existingBook.setBookContent(book.getBookContent());
			existingBook.setBookDescription(book.getBookDescription());
			existingBook.setBookLogo(book.getBookLogo());
			existingBook.setBookPrice(book.getBookPrice());
			existingBook.setBookPublishedDate(book.getBookPublishedDate());
			existingBook.setBookPublisher(book.getBookPublisher());
			System.out.println(existingBook.getBookTitle());
			existingBook.setBookAuthor(author);
		    existingBook= bookRepository.save(existingBook);
		}
		catch(Exception ex) {
			throw new BookServiceException("Book creation Failed!");
		}
		return existingBook.getBookTitle()+" Created!";
	}

	@Override
	public Optional<Book> getBookAllDetails(Integer id) {
		return bookRepository.findById(id);
	}

	@Override
	public List<Book> listAllBookInfo() {
		List<Book> bookList = bookRepository.findAll();
		return bookList;
	}

	@Override
	public String updateBookContent(BookInfodto book, Integer id) {
		String status="Not able to update book, Kindly check logs!";
		Book existingBook = bookRepository.findById(id).orElseThrow(
				()-> new com.book.exceptions.ResourceNotFoundExceptionHandler("Book","id",id));
		if(existingBook!=null) {
			existingBook.setBookTitle(book.getBookTitle());
			existingBook.setBookActive(book.isBookActive());
			existingBook.setBookCategory(book.getBookCategory());
			existingBook.setBookContent(book.getBookContent());
			existingBook.setBookDescription(book.getBookDescription());
			existingBook.setBookLogo(book.getBookLogo());
			existingBook.setBookPrice(book.getBookPrice());
			existingBook.setBookPublishedDate(book.getBookPublishedDate());
			existingBook.setBookPublisher(book.getBookPublisher());
			existingBook.setBookId(book.getBookId());
			bookRepository.save(existingBook);
			status="Updated Book '"+existingBook.getBookTitle()+"'";
			}
			return status;
		
	}

	@Override
	public Book updateBookStatus(Book book, Integer id) {
		Book existingBook = bookRepository.findById(id).orElseThrow(
				()-> new com.book.exceptions.ResourceNotFoundExceptionHandler("Book","id",id));
		existingBook.setBookActive(book.isBookActive());
		bookRepository.save(existingBook);
		return existingBook;
	}

	@Override
	public List<Book> listBookByCategory(String bookCategory) {
		List<Book> bookList = bookRepository.findByBookCategory(bookCategory);
		return bookList;
	}

	@Override
	public String getAuthorNameByBookId(int bookId) {
		List<IBookInfo> bookInfo = bookRepository.findByBookId(bookId);
		IBookInfo bookInfoObj = bookInfo.get(0);
		String authorName = bookInfoObj.getbookAuthor().getAuthorName();
		return authorName;
	}

	@Override
	public List<Book> getBookByTitle(String bookTitle) {
		
		List<Book> bookList = bookRepository.findByBookTitle(bookTitle);
		return bookList;
		
	}

	@Override
	public String getBookContentById(String bookTitle) {
		List<Book> book = bookRepository.findByBookTitle(bookTitle);
		return book.get(0).getBookContent();
	}

	@Override
	public ResponseEntity<?> createAuthor(Author author) {
		authorRepository.save(author);
		return ResponseEntity.ok("Author registered with book service!");
	}

	@Override
	public List<Book> listBookByPublisher(String bookPublisher) {
		List<Book> book = bookRepository.findByBookPublisher(bookPublisher);
		return book;
	}

	@Override
	public List<Book> listBookByAuthor(Author author) {
		List<Book> book = bookRepository.findByBookAuthor(author);
		return book;
	}
	
	

}
