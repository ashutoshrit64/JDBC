package com.bridgelabz.crudstatements;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Statement;

public class CreateStatement {
	public static void main(String args[]) throws Exception
	{
		String query="create table login(username varchar(25),emaiid varchar(100),password varchar(100), age int(20),city varchar(40) )";
		   Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdata","root","password");
		if(con!=null)
		{
			System.out.println("connection established!!!!");
		}
		else
		{
			System.out.println("not established!!!!");
		}
		Statement st= (Statement) con.createStatement();
		st.executeUpdate(query);
		System.out.println("table created");
		st.close();
		
		
	
	}
}
