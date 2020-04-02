package com.HotelBookingSystem.controller;

import com.HotelBookinSystem.connection.ConnectionClass;
import com.HotelBookingSystem.controller.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/report")
public class report extends HttpServlet{
	
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		
		boolean result= false;
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String reportfor=request.getParameter("generatereport");  
        String date=request.getParameter("date");
        
        username.clear();
        roomtype.clear();
        noofguests.clear();
        adate.clear();
        ddate.clear();
        
        try {
        	if(reportfor.equalsIgnoreCase("FA"))
        		result=report();
        	else
        		result=report(date);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("roomtype", roomtype);
        session.setAttribute("noofguests", noofguests);
        session.setAttribute("arrivaldate", adate);
        session.setAttribute("departuredate", ddate);
        
        
        if(result == true && reportfor.equalsIgnoreCase("FA")){  
        	request.getRequestDispatcher("displayreport.jsp").include(request, response);
        }else if(result == true && reportfor.equalsIgnoreCase("FD")) {
        	request.getRequestDispatcher("displayreportforday.jsp").include(request, response);
        }
        else{  
            out.println("Sorry! Unable to Get Report");  
        }  
          
        out.close();  
		
	}
	
	public boolean report() throws SQLException, ClassNotFoundException {
		
		Connection connection = object.connection();

		preparedStatement = connection.prepareStatement("Select * from reservations");
		
		resultSet=preparedStatement.executeQuery();
		
		if(resultSet.next())
		{
			do
			{
				username.add(resultSet.getString(1));
				roomtype.add(resultSet.getString(2));
				noofguests.add(resultSet.getInt(3));
				adate.add(resultSet.getString(4));
				ddate.add(resultSet.getString(5));
			}while(resultSet.next());
			
			result = true;
		}
		else
			result = false;
	
		return result;
	}
	
	public boolean report(String date) throws SQLException, ClassNotFoundException {
		
		Connection connection = object.connection();

		preparedStatement = connection.prepareStatement("Select * from reservations where arrivaldate<=? and departuredate>=?");
		preparedStatement.setString(1,date);
		preparedStatement.setString(2,date);
		
		resultSet=preparedStatement.executeQuery();
		
		if(resultSet.next())
		{
			do
			{
				username.add(resultSet.getString(1));
				roomtype.add(resultSet.getString(2));
				noofguests.add(resultSet.getInt(3));
			}while(resultSet.next());
			
			
			result = true;
		}
		else
			result = false;
	
		return result;
	}
	

}
