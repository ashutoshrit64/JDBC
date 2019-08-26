package batchprocessing;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class createbatch 
{
	public static void main(String [] args) throws Exception

	{

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "password");
		Statement st = (Statement) con.createStatement();
		st.addBatch(
				"create table employees(od int(5) primary key,name varchar(20),DOB varchar(1000))");
//		st.addBatch(
//				"create table Student2(rollno int(5) primary key,name varchar(20),Address varchar(20),MobileNo int(10))");
//		st.addBatch(
//				"create table Student3(rollno int(5) primary key,name varchar(20),Address varchar(20),MobileNo int(10))");
		st.executeBatch();
		System.out.println("Tables created in database");
		con.close();


}





	}	

