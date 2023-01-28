package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.Block;
import com.user.repository.IBlockRepository;

@Service
public class BlockServiceImpl implements IBlockService{

	@Autowired
	IBlockRepository blockRepo;
	
	@Override
	public String addBlock(int userId, int bookId) {
		Block block = new Block();
		block.setUserId(userId);
		block.setBookId(bookId);
		blockRepo.save(block);
		return "Book "+bookId+" blocked!";
	}

	@Override
	public Boolean getBooksByUserIdBookId(int userId,int bookId) {
		Block block = blockRepo.findByUserIdAndBookId(userId,bookId);
		return block == null?false:true;
	}
	
	
}
