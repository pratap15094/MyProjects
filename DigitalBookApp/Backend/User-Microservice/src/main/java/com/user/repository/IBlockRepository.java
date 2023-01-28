package com.user.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.Block;


public interface IBlockRepository extends JpaRepository<Block,Integer>{
	public Block findByUserIdAndBookId(int userId,int bookId);
	
	public List<Block> findByUserId(int id);
}
