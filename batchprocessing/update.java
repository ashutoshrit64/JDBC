package batchprocessing;

import java.sql.DriverManager;
import java.sql.SQLException;

public class update 
{
public static void main(String[] args) throws Exception
{
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","password");
	java.sql.Statement st = con.createStatement();
	con.setAutoCommit(false);
	String query1="update replica set name='mayur' where rollno=4";
	st.addBatch(query1);                                               
	String query2="update replica set Address='nagpur' where rollno=4";
	st.addBatch(query2);
	int count[]= st.executeBatch();
	
	System.out.println(count.length);
	System.out.println("query executed in database");
	con.commit();
	con.close();

}
}
