package com.book.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int bookId;
	private String bookTitle;
	@JsonBackReference
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="authorId")
	private Author bookAuthor;
	private String bookCategory;
	private int bookPrice;
	private String bookPublisher;
	private String bookPublishedDate;
	private String bookLogo;
	private String bookDescription;
	private String bookContent;
	private boolean bookActive;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String bookTitle, Author bookAuthor, String bookCategory, int bookPrice,
			String bookPublisher, String bookPublishedDate, String bookLogo, String bookDescription, String bookContent,
			boolean bookActive) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookCategory = bookCategory;
		this.bookPrice = bookPrice;
		this.bookPublisher = bookPublisher;
		this.bookPublishedDate = bookPublishedDate;
		this.bookLogo = bookLogo;
		this.bookDescription = bookDescription;
		this.bookContent = bookContent;
		this.bookActive = bookActive;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Author getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(Author bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookPublishedDate() {
		return bookPublishedDate;
	}

	public void setBookPublishedDate(String bookPublishedDate) {
		this.bookPublishedDate = bookPublishedDate;
	}

	public String getBookLogo() {
		return bookLogo;
	}

	public void setBookLogo(String bookLogo) {
		this.bookLogo = bookLogo;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookContent() {
		return bookContent;
	}

	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}

	public boolean isBookActive() {
		return bookActive;
	}

	public void setBookActive(boolean bookActive) {
		this.bookActive = bookActive;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookCategory="
				+ bookCategory + ", bookPrice=" + bookPrice + ", bookPublisher=" + bookPublisher
				+ ", bookPublishedDate=" + bookPublishedDate + ", bookLogo=" + bookLogo + ", bookDescription="
				+ bookDescription + ", bookContent=" + bookContent + ", bookActive=" + bookActive + "]";
	}

}
