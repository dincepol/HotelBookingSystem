package com.HotelBookingSystem.controller;

import com.HotelBookingSystem.controller.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bookrooms")
public class bookrooms extends HttpServlet{
	
	ControllerClass object;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		boolean result= false;
		object = new ControllerClass();
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String passwordfromuser=request.getParameter("password");
        
        HttpSession session=request.getSession();
        String passwordfromsession=(String) session.getAttribute("password");
        
        if(passwordfromsession.equals(passwordfromuser))
        {
        	
        	String arrivaldate=(String) session.getAttribute("arrivaldate");
            String departuredate=(String) session.getAttribute("departuredate");
            String typeofroom=(String) session.getAttribute("typeofroom");
            String username=(String) session.getAttribute("user");
            String noofguests=(String) session.getAttribute("numberofguests");
            
            System.out.println(username);
        	try {
        		result = object.bookrooms(arrivaldate, departuredate, typeofroom, username , noofguests);
        	} catch (ClassNotFoundException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	} catch (SQLException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        
        
        if(result==true){  
            out.print("Rooms Booked succesfully!");
            request.getRequestDispatcher("home.jsp").include(request, response);  
        }else{  
            out.println("Sorry! Booking unsuccesful! please try again later");  
        }  
        	
        }
        else
        	out.print("Wrong Password !!");
        out.close();  
		
	}
	

}
