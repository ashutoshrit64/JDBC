package com.bridgelabz.crudstatements;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Connection;

public class Delete 
{
	public static void main(String [] args) throws ClassNotFoundException, Exception 
	{
	Scanner scan=new Scanner(System.in);
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newdata","root","password");
	Statement st=con.createStatement();
//	System.out.println("username");
//	String username=scan.next();
	st.execute("drop database newdata");
	//st.execute("delete from login where emaiid = 'singhprince'");
	System.out.println("deleted");
	con.close();
	
	
	
	
}}
