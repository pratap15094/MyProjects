package com.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.book.entity.Author;
import com.book.entity.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {
	
	List<IBookInfo> findByBookId(Integer bookId);
	
	List<Book> findByBookCategoryAndBookTitleAndBookPriceAndBookPublisher(String bookCategory,String bookTitle,int bookPrice,String bookPublisher);

	List<Book> findByBookCategory(String bookCategory);
	
	List<Book> findByBookTitle(String bookTitle);
	
	List<Book> findByBookPublisher(String bookPublisher);
	
	List<Book> findByBookAuthor(Author author);

}
