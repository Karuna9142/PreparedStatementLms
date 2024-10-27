package com.prepared;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CollableStatementEx {

	public static void main(String[] args) {


	try
	{
		//Database credential
		Class.forName("com.mysql.cj.jdbc.Driver"); //loading the driver
		//creating connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/preparedDemo","root","Mishra12345#");
		
		//Sql query
		String query = "insert into Employee(id,name,age,address) values (?,?,?,?)";
		//Collable statement
		CallableStatement clb = con.prepareCall(query);
		CallableStatement clb1= con.prepareCall(query);
		CallableStatement clb2 = con.prepareCall(query);
		
		System.out.println("Data inserted successfully...");
		
		//set the value to insert
		clb.setInt(1, 1);
		clb.setString(2, "Neha");
		clb.setInt(3, 24);
		clb.setString(4, "Kodarma");
		
		clb1.setInt(1, 2);
		clb1.setString(2, "Priya");
		clb1.setInt(3, 25);
		clb1.setString(4, "Gumla");
		
		clb2.setInt(1, 3);
		clb2.setString(2, "Riya");
		clb2.setInt(3, 26);
		clb2.setString(4, "Chatra");
		
		clb.execute();
		clb1.execute();
		clb2.execute();
		
		clb.close();
		clb1.close();
		clb2.close();
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}

	}

}
