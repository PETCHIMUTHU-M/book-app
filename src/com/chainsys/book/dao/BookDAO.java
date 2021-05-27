package com.chainsys.book.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.chainsys.book.model.Book;

public interface BookDAO {
	Set<Book> findAll();

	List<String> findAllName();

	List<Integer> findAllId();

	List<Date> findAllDate();

	Set<Book> findById(int id);

	Set<Book> findByName(String name);

}
