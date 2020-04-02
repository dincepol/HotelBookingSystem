package com.HotelBookingSystem.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import com.HotelBookinSystem.connection.ConnectionClass;

public class ControllerClass {
	
		boolean result=false;
		ResultSet resultSet = null;
		String passwordfromDB=null;
		PreparedStatement preparedStatement = null;
		List username= new ArrayList();
		List roomtype= new ArrayList();
		List noofguests= new ArrayList();
		List adate= new ArrayList();
		List ddate= new ArrayList();
		ConnectionClass object = new ConnectionClass();
		
	
	
	public boolean checklogin(String username,String password) throws ClassNotFoundException, SQLException{
		
		Connection connection = object.connection();
		
		preparedStatement = connection.prepareStatement("Select password from details where username=?");
		preparedStatement.setString(1,username);
		
		
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			passwordfromDB=resultSet.getString(1);
			
			if(password.equals(passwordfromDB))
			{
				result=true;
			}
			else
			{
				result=false;
			}
		}
		else
		{
			result=false;
		}
		
		return result;  
    }  
	
public boolean checkadminlogin(String username,String password) throws ClassNotFoundException, SQLException{
		
		Connection connection = object.connection();
		
		preparedStatement = connection.prepareStatement("Select admin_password from admin_cred where admin_username=?");
		preparedStatement.setString(1,username);
		
		
		resultSet=preparedStatement.executeQuery();
		if(resultSet.next())
		{
			passwordfromDB=resultSet.getString(1);
			
			if(password.equals(passwordfromDB))
			{
				result=true;
			}
			else
			{
				result=false;
			}
		}
		else
		{
			result=false;
		}
		
		return result;  
    }  
	
	public boolean register(String username,String password,String name, String email, String mobile) throws SQLException, ClassNotFoundException {
		
		Connection connection = object.connection();
		
		preparedStatement = connection.prepareStatement("insert into details values (?,?,?,?,?)");
		preparedStatement.setString(1,username);
		preparedStatement.setString(2, password);
		preparedStatement.setString(3, name);
		preparedStatement.setString(4, email);
		preparedStatement.setString(5, mobile);
		
		int resultvalue=preparedStatement.executeUpdate();
		
		if(resultvalue!=0)
		{
			result = true;
		}
	
		return result;
	}
	
	public boolean searchrooms(String arrival,String departure, String typeofroom) throws ClassNotFoundException, SQLException {
		
		Connection connection = object.connection();
	
		
		
		
		preparedStatement = connection.prepareStatement("select * from reservations where (arrivaldate<=? && departuredate>=? && roomtype=?) or (arrivaldate<=? && departuredate>=? && roomtype=?) or (arrivaldate>=? && departuredate<=? && roomtype=?)");
		preparedStatement.setString(1,arrival);
		preparedStatement.setString(2,arrival);
		preparedStatement.setString(3, typeofroom);
		preparedStatement.setString(4, departure);
		preparedStatement.setString(5, departure);
		preparedStatement.setString(6, typeofroom);
		preparedStatement.setString(7,arrival);
		preparedStatement.setString(8, departure);
		preparedStatement.setString(9, typeofroom);
		resultSet=preparedStatement.executeQuery();
		
		if(resultSet.next())
		{
			result = false;
		}
		else
		{
			result=true;
		}
		return result;
	
	}
	
	public boolean bookrooms(String arrivaldate, String departuredate, String typeofroom, String username, String noofguests) throws ClassNotFoundException, SQLException {
		
		Connection connection = object.connection();
		
		System.out.println(username);
		preparedStatement = connection.prepareStatement("insert into reservations values (?,?,?,?,?)");
		preparedStatement.setString(1,username);
		preparedStatement.setString(2,typeofroom);
		preparedStatement.setString(3,noofguests);
		preparedStatement.setString(4,arrivaldate);
		preparedStatement.setString(5,departuredate);
		
		
		int resultvalue=preparedStatement.executeUpdate();
		
		if(resultvalue!=0)
		{
			result = true;
		}
		
		return result;
	}
	
	public boolean addroom(String typeofroom,int numberofrooms) throws SQLException, ClassNotFoundException {
		
		Connection connection = object.connection();

		preparedStatement = connection.prepareStatement("update rooms set noofrooms=noofrooms+? where room_type=?");
		preparedStatement.setInt(1, numberofrooms);
		preparedStatement.setString(2,typeofroom);
		
		
		int resultvalue=preparedStatement.executeUpdate();
		
		if(resultvalue!=0)
		{
			result = true;
		}
	
		return result;
	}
	
	public boolean capacitychange(String typeofroom,int capacitychange) throws SQLException, ClassNotFoundException {
		
		Connection connection = object.connection();

		preparedStatement = connection.prepareStatement("update rooms set capacity=capacity+? where room_type=?");
		preparedStatement.setInt(1, capacitychange);
		preparedStatement.setString(2,typeofroom);
		
		
		int resultvalue=preparedStatement.executeUpdate();
		
		if(resultvalue!=0)
		{
			result = true;
		}
	
		return result;
	}
	
	
}

