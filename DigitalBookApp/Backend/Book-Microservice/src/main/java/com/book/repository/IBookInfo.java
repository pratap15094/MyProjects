package com.book.repository;

import com.book.entity.Author;

public interface IBookInfo {
	Integer getbookId();
	String getBookTitle();
	Author getbookAuthor();
	String getbookCategory();
	int getbookPrice();
	String getbookPublisher();
	String getbookPublishedDate();
	String getbookDescription();
	String getbookLogo();
}
