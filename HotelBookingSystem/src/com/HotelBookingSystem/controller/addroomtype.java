package com.HotelBookingSystem.controller;

import com.HotelBookingSystem.controller.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addroomtype")
public class addroomtype extends HttpServlet{
	
	ControllerClass object;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		boolean result= false;
		object = new ControllerClass();
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String typeofroom=request.getParameter("typeofroom");  
        int roomstoadd=Integer.parseInt(request.getParameter("roomstoadd"));
        
         try {
        	 
			result = object.addroom(typeofroom, roomstoadd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(result == true){  
            out.print("<p>Updated successfully!</p>");  
           request.getRequestDispatcher("adminhome.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to Update");  
        }  
          
        out.close();  
		
	}
	

}
