package com.bridgelabz.crudcollablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Create 
{
	public static void main(String[] args) throws Exception
{
		
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","password");
	CallableStatement cst=con.prepareCall("{call  employees.new_procedure()}");

	cst.execute();
    cst.registerOutParameter(1, java.sql.Types.VARCHAR);
	
	
	
	
}
}
