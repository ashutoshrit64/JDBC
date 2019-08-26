package com.bridgelabz.crudpreparedstatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class LoginRegistration
	{
	static Scanner scan=new Scanner(System.in);
	public static void signin() throws Exception
	{

		System.out.println("Enter your name:");
		String user=scan.next();
		System.out.println("Enter email id:");
		String email=scan.next();
		System.out.println("Enter password:");
		String pass=scan.next();
		System.out.println("enter age");
		int age=scan.nextInt();
		System.out.println("enter city");
		String city=scan.next();
		String query=String.format("insert into login values('%s','%s','%s','%d','%s')",user,email,pass,age,city);;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","password");
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
		System.out.println("Succesfully created your account.....");
		st.close();
}
	public static void login() throws Exception
	{
		System.out.println("Enter your email:");
		String emailid=scan.next();
	    System.out.println("enter password:");
		String password=scan.next();
		//String query="select * from login where emaiid='singhprince'";	//where emaiid='ashutosh@42'
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","password");
		String sql="select * from login where emaiid = '" + emailid+"' and password='"+password+"'";
		java.sql.PreparedStatement statement = con.prepareStatement(sql);
		
		ResultSet rs=statement.executeQuery();
		if(rs.next())
		{
			System.out.println("Name:"+rs.getString(1));
			System.out.println("Email:"+rs.getString(2));
			//System.out.println(""+rs.getString(3));
			System.out.println("Age:"+rs.getInt(4));
			System.out.println("City:"+rs.getString(5));
		}
		else
		{
			System.out.println("wrong password or user name entered!!!!!");
			System.out.println("Enter correct details.....");
		}
		
		//System.out.println(rs);
			
		
	}
	
	
	public static void delete() throws Exception
	{
		System.out.println("Enter your email:");
		String emailid=scan.next();
	    System.out.println("enter password:");
		String password=scan.next();
		//String query="select * from login where emaiid='singhprince'";	//where emaiid='ashutosh@42'
		Class.forName("com.mysql.jdbc.Driver");
		String sql="delete from login where emaiid = '" + emailid+"' and password='"+password+"'";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","password");
		java.sql.PreparedStatement statement = con.prepareStatement(sql);
		int affect=statement.executeUpdate();
		if(affect>0)
		{
			System.out.println("succesfully deleted........");
	}
		else
		{
			System.out.println("wrong data entered....");
		}
	}
	public static void reset() throws  Exception
	{
		System.out.println("-----RESET PASSWORD-----");
		System.out.println("Enter your email:");
		String emailid=scan.next();
	    System.out.println("enter age :");
		String age=scan.next();
		System.out.println("enter new password:");
		String password=scan.next();
		//String query="select * from login where emaiid='singhprince'";	//where emaiid='ashutosh@42'
		Class.forName("com.mysql.jdbc.Driver");
		String sql="update login set password='"+password+"' where  emaiid='"+emailid+"' and age='"+age+"'";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","password");
		java.sql.PreparedStatement statement = con.prepareStatement(sql);
		int affect=statement.executeUpdate();
		if(affect>0)
		{
			System.out.println("succesfully set........");
	}
		else
		{
			System.out.println("wrong data entered....");
		}
		
		

	}
	
	public static void main(String[] args) throws Exception
	{ 
		boolean value=true;
		while(value)
		{
		System.out.println("--------------------------------Welcome to login registration page------------------------------");
		System.out.println("**************CHOOSE ANY ONE FROM FOLLOWING OPTIONS********************");
		System.out.println("1) LOG IN TO SEE YOUR ACCOUNT \n2) SIGN IN TO CREATE YOUR ACCOUNT \n"
				+ "3) DELETE YOUR ACCOUNT \n4) CLOSE ");
		System.out.println("ENTER YOUR CHOICE -->");
		int n=scan.nextInt();
		switch(n)
		{
		case 1:
			System.out.println("-----WELCOME TO LOGIN--------");
			System.out.println("Enter following details");
			LoginRegistration.login();
			break;
		case 2:
			System.out.println("-----CREATE NEW ACCOUNT------");
			System.out.println("Enter following details");
			LoginRegistration.signin();
			break;
		case 3:
			LoginRegistration.delete();
			break;
		case 5:
			LoginRegistration.reset();
		case 4: System.out.println("Page Closed.....");
		    	value=false;
		    	break;
		   default:
		    		System.out.println("enter valid input...");
		}
		
		
		}
	}
}
