package com.bridgelabz.crudstatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Read
{

public static void main(String []args) throws ClassNotFoundException, Exception
{
	String query="select * from login";
	   Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","password");
	Statement st=   (Statement) con.createStatement();
	ResultSet rs=st.executeQuery(query);
	System.out.println("-------------DATABASE---------------------");
	while(rs.next())
	{
		
		System.out.print(rs.getString(1)+"\t");
		
		System.out.print(rs.getString(2)+"\t");
		
		System.out.print(rs.getString(3)+"\t");

	}
	
	st.close();
}
	

	
	
	
	
}
