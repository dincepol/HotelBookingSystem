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

@WebServlet("/register")
public class register extends HttpServlet{
	
	ControllerClass object;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		boolean result= false;
		object = new ControllerClass();
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String username=request.getParameter("username");  
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String mobile=request.getParameter("mobile");
        
         try {
			result= object.register(username, password, name, email, mobile);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(result == true){  
            out.print("<p>Registered successfully!</p>");  
            request.getRequestDispatcher("login.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to Register");  
        }  
          
        out.close();  
		
	}
	

}
