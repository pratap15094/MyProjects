package com.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Block {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer blockId;
	private int userId;
	private int bookId;
	public Block() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Block(Integer blockId, int userId, int bookId) {
		super();
		this.blockId = blockId;
		this.userId = userId;
		this.bookId = bookId;
	}
	public Integer getBlockId() {
		return blockId;
	}
	public void setBlockId(Integer blockId) {
		this.blockId = blockId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	
}
