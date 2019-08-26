package batchpreparedstatement;

import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CreateBatch 
{
	
	public static void main(String[] args) throws Exception
	{
		Scanner scn = new Scanner(System.in);	

		System.out.println("Enter the rollno:");
		int roll = scn.nextInt();
		System.out.println("Enter the name:");
		String name = scn.next();
		System.out.println("Enter the address:");
		String addr = scn.next();
		System.out.println("Enter the Mobile No:");
		long mbno = scn.nextInt();

		String query = String.format("insert into replica values(%d,'%s','%s',%d)", roll, name, addr, mbno);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/newdata", "root", "password");
		PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
		st.addBatch();
		st.execute();
		System.out.println("Tables created in database");
		con.close();
		
		
	}
	
	
	
	
}
