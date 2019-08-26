package com.bridgelabz.crudstatements;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Statement;

public class Update {

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		String query="update login set username='Ashutosh' where password='ASHU'";
		   Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","password");
		
		Statement st= (Statement) con.createStatement();
		st.executeUpdate(query);
		System.out.println("UPDATED....");
		System.out.println("values inserted into table");
		st.close();
		
		
		
		
		
		

	}

}
