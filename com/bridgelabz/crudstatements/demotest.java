package com.bridgelabz.crudstatements;
import java.sql.*;

public class demotest 
{
	public static void main(String args[]) throws Exception
	{

		   Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","password");
		if(con!=null)
		{
			System.out.println("connection established!!!!");
		}
		else
		{
			System.out.println("not established!!!!");
		}
	}
	
}
