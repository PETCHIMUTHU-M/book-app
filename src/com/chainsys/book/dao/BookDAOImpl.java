package com.chainsys.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chainsys.book.model.Book;

public class BookDAOImpl implements BookDAO {

	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<Book> bookSet;
	private static List<String> namelist;
	private static List<Integer> idlist;
	private static List<Date> datelist;

	public BookDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "password");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:EBS1228", "apps", "apps");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Book> findAll() {
		try {
			pstmt = con.prepareStatement("select * from books_2597");
			rs = pstmt.executeQuery();
			bookSet = new HashSet<>();
			while (rs.next()) {
				Book book = new Book(rs.getInt("id"), rs.getString("name"), rs.getDate("published_date").toLocalDate());
				bookSet.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookSet;
	}

	@Override
	public List<String> findAllName() {
		try {
			pstmt = con.prepareStatement("select name from books_2597");
			rs = pstmt.executeQuery();
			namelist = new ArrayList<>();
			while (rs.next()) {
				namelist.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return namelist;
	}

	@Override
	public List<Integer> findAllId() {
		try {
			pstmt = con.prepareStatement("select id from books_2597");
			rs = pstmt.executeQuery();
			idlist = new ArrayList<>();
			while (rs.next()) {
				idlist.add(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idlist;
	}

	@Override
	public List<Date> findAllDate() {
		try {
			pstmt = con.prepareStatement("select published_date from books_2597");
			rs = pstmt.executeQuery();
			datelist = new ArrayList<>();
			while (rs.next()) {
				datelist.add(rs.getDate("published_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datelist;
	}

	@Override
	public Set<Book> findById(int id) {
		try {
			pstmt = con.prepareStatement("select * from books_2597 where id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			bookSet = new HashSet<>();
			while (rs.next()) {
				Book book = new Book(rs.getInt("id"), rs.getString("name"), rs.getDate("published_date").toLocalDate());
				bookSet.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookSet;
	}

	@Override
	public Set<Book> findByName(String name) {
		try {
			pstmt = con.prepareStatement("select * from books_2597 where name=?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			bookSet = new HashSet<>();
			while (rs.next()) {
				Book book = new Book(rs.getInt("id"), rs.getString("name"), rs.getDate("published_date").toLocalDate());
				bookSet.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookSet;
	}

}
