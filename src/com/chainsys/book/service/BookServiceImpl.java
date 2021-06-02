package com.chainsys.book.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.chainsys.book.dao.BookDAO;
import com.chainsys.book.dao.BookDAOImpl;
import com.chainsys.book.model.Book;

public class BookServiceImpl implements BookService{
	
	private static BookDAO dao;
	
	public BookServiceImpl() {
		dao = new BookDAOImpl();
	}

	@Override
	public Set<Book> findAll() {
		return dao.findAll();
		
	}

	@Override
	public List<String> findAllName() {
		return dao.findAllName();
	}

	@Override
	public List<Integer> findAllId() {
		return dao.findAllId();
	}

	@Override
	public List<Date> findAllDate() {
		return dao.findAllDate();
	}

	@Override
	public Set<Book> findById(int id) {
		return dao.findById(id);
	}

	@Override
	public Set<Book> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public Set<Book> findByDate(String date) {
		return dao.findByDate(date);
	}

	@Override
	public String findNameById(int id) {
		return dao.findNameById(id);
	}
	
	@Override
	public int findIdByName(String name) {
		return dao.findIdByName(name);
	}

}
