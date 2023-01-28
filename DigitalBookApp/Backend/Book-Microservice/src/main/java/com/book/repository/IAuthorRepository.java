package com.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Author;

public interface IAuthorRepository extends JpaRepository<Author,Integer> {
	public List<Author> findByAuthorName(String name);
}
