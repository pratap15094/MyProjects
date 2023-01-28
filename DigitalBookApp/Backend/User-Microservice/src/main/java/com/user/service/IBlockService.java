package com.user.service;

public interface IBlockService {
	public String addBlock(int userId,int bookId);
	
	public Boolean getBooksByUserIdBookId(int userId,int bookId);

}
