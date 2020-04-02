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

@WebServlet("/searchrooms")
public class searchrooms extends HttpServlet{
	
	ControllerClass object;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		boolean result= false;
		object = new ControllerClass();
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String arrivaldate=request.getParameter("adate");
        String departuredate=request.getParameter("ddate");
        String typeofroom=request.getParameter("typeofroom");
        String noofguests=(request.getParameter("noofguests"));
        
     
        try {
			result = object.searchrooms(arrivaldate, departuredate, typeofroom);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        if(result==true){  
        	
        	HttpSession session=request.getSession();  
            session.setAttribute("arrivaldate",arrivaldate);
            session.setAttribute("departuredate", departuredate);
            session.setAttribute("typeofroom", typeofroom);
            session.setAttribute("numberofguests", noofguests);
            out.print("<p>Rooms available!</p>");  
            out.print("<button onclick=\"window.location.href = 'makebooking.jsp';\">Book Now</button>");
           
        }else{  
            out.println("<p>Sorry! No rooms found, try another date or type.<p>");  
        }  
          
        out.close();  
		
	}
	

}
