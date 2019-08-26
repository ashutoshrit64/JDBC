package batchprocessing;

import java.sql.DriverManager;

public class delete
{
public static void main(String[] args) throws Exception
{
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","password");
	java.sql.Statement st = con.createStatement();
	con.setAutoCommit(false);
	String query1="delete from replica where name='zia'";
	st.addBatch(query1);
	
	int count[]= st.executeBatch();
	
	System.out.println(count.length);
	System.out.println("query executed in database");
	con.commit();
	con.close();
	
	
}
	
	
	
}
