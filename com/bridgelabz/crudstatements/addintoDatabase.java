package com.bridgelabz.crudstatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class addintoDatabase 
{
	static Scanner scan=new Scanner(System.in);
	public static void main(String []args) throws ClassNotFoundException, Exception
	{	
		System.out.println("Enter your name:");
		String user=scan.next();
		System.out.println("Enter email id:");
		String email=scan.next();
		System.out.println("Enter password:");
		String pass=scan.next();
		String query=String.format("insert into login values('%s','%s','%s')",user,email,pass);;
		   Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","password");
		
		Statement st= (Statement) con.createStatement();
		st.executeUpdate(query);
		System.out.println("table created");
		System.out.println("values inserted into table");
		st.close();
	}
	
	

}
