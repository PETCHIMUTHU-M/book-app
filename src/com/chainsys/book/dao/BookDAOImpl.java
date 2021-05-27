package com.chainsys.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chainsys.book.model.Book;

public class BookDAOImpl implements BookDAO{
	
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<Book> bookSet;
	private static List<String> namelist;
	private static List<Integer> idlist;

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
				Book book = new Book(rs.getInt("id"), rs.getString("name"),
						rs.getDate("published_date").toLocalDate());
				bookSet.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookSet;
	}
	
}

