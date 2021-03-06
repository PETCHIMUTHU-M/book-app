package com.chainsys.book.test;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.book.model.Book;
import com.chainsys.book.service.BookService;
import com.chainsys.book.service.BookServiceImpl;

public class BookClient {
	public static void main(String[] args) {

		Set<Book> bookSet;
		List<String> namelist;
		List<Integer> idlist;
		List<Date> datelist;
		int id;
		String name;
		String date;

		BookService service = new BookServiceImpl();

		System.out.println("Enter your choice : ");
		Scanner scanner = new Scanner(System.in);

		int choice = scanner.nextInt();
		switch (choice) {

		case 1:
			System.out.println("Find All Books");
			bookSet = service.findAll();
			System.out.println(bookSet);
			break;

		case 2:
			System.out.println("Find all Books Name");
			namelist = service.findAllName();
			System.out.println(namelist);
			break;

		case 3:
			System.out.println("Find all Books Id");
			idlist = service.findAllId();
			System.out.println(idlist);
			break;

		case 4:
			System.out.println("Find all Books Published Date");
			datelist = service.findAllDate();
			System.out.println(datelist);
			break;

		case 5:
			System.out.println("Find Book by Id");
			System.out.println("Enter the Id");
			id = scanner.nextInt();
			bookSet = service.findById(id);
			System.out.println(bookSet);
			break;
			
		case 6:
			System.out.println("Find Book by Name");
			System.out.println("Enter the Name");
			name = scanner.next();
			bookSet = service.findByName(name);
			System.out.println(bookSet);
			break;	
			
		case 7:
			System.out.println("Find Book by Published Date");
			System.out.println("Enter the Date in the dd/mm/yy format");
			date = scanner.next();
			bookSet = service.findByDate(date);
			System.out.println(bookSet);
			break;
			
		case 8:
			System.out.println("Find Book name by Id");
			System.out.println("Enter the Id");
			id = scanner.nextInt();
			name = service.findNameById(id);
			System.out.println(name);
			
		case 9:
			System.out.println("Find Book Id by Name");
			System.out.println("Enter the Name");
			name = scanner.next();
			id = service.findIdByName(name);
			System.out.println(id);
			
		default:
			break;
		}
		scanner.close();
	}

}
