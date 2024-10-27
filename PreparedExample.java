package com.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedExample {
	
	public static void prepared_create()
	{
		try
		{
			//Database details to connect with database
			Class.forName("com.mysql.cj.jdbc.Driver"); // loading the driver
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/preparedDemo", "root", "Mishra12345#");//making connection 
			String query = "create table Student(id int primary key,name varchar(20),Age int, address varchar(20))";//sql query where i created one table
			
			PreparedStatement pst = con.prepareStatement(query);//prepared statement is an interface
			pst.execute();//executing the query
			
			System.out.println("Table created Successfully");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void prepared_insert()
	{
		try
		{
			//database credential
			Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/preparedDemo", "root", "Mishra12345#");//connection with dbms
			String query = "insert into Student(id,name,age,address) values (?,?,?,?)";// sql query to insert data
			
			//prepared statement
			PreparedStatement pst = con.prepareStatement(query);
			PreparedStatement pst1 = con.prepareStatement(query);
			PreparedStatement pst2 = con.prepareStatement(query);
		
			//set the value to insert
			pst.setInt(1, 101);
			pst.setString(2, "Karuna");
			pst.setInt(3, 22);
			pst.setString(4, "Ranchi");
			
			pst1.setInt(1, 102);
			pst1.setString(2, "Smriti");
			pst1.setInt(3, 25);
			pst1.setString(4, "Ranchi");
			
			pst2.setInt(1, 103);
			pst2.setString(2, "Anjali");
			pst2.setInt(3, 23);
			pst2.setString(4, "MP");
			
			pst.execute();
			pst1.execute();
			pst2.execute();
			
			
			System.out.println("data inserted Successfully");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		//instance of PreparedExample class
		PreparedExample p1 = new PreparedExample();
	
		//called the method
		p1.prepared_create();
		p1.prepared_insert();
	
	}

}
