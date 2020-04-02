package com.HotelBookinSystem.connection;

import java.sql.*;

public class ConnectionClass  {
	
 String url = "jdbc:mysql://localhost:3306/hotelbookingsystem?" + "autoReconnect=true&useSSL=false";
 String user = "root"; 
 String pass = "root"; 
	
	        
	public Connection connection() throws SQLException, ClassNotFoundException 
	{	
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pass);
		
		return con;	
	}
	
}
