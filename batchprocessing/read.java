package batchprocessing;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class read
{
	public static void main(String [] args) throws Exception
	{

		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","password");
		java.sql.Statement st = con.createStatement();
		con.setAutoCommit(false);
		String query="select * from replica";
		
		ResultSet rs=st.executeQuery(query);
		st.addBatch(rs.toString());
		while(rs.next())
		{
			System.out.println(" ");
			System.out.println("rollno."+rs.getString(1));
			System.out.println("name"+rs.getString(2));
			System.out.println("city"+rs.getString(3));
			System.out.println("mob no."+rs.getString(4));
			System.out.println();
		}
		
	//		int count[]= st.executeBatch();
		//System.out.println(count.length);
		System.out.println("query executed in database");
		con.commit();
		con.close();
		
		
		
		
		
		
	}

}
