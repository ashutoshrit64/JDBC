package batchpreparedstatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class update
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/transaction'","root","password");
		java.sql.Statement st = con.createStatement();
		con.setAutoCommit(false);
		String query1="update transaction set salary=500000 where department='Engineering'";
		st.addBatch(query1);                                               
		String query2="DELETE from transaction where department = 'HR'";
		st.addBatch(query2);
		int count[]= st.executeBatch();
		
		System.out.println(count.length);
		System.out.println("query executed in database");
		con.commit();
		con.close();

	}
}
