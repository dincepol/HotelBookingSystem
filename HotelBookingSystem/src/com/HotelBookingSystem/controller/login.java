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
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet{
	
	ControllerClass object;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		boolean result= false;
		object = new ControllerClass();
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String name=request.getParameter("username");  
        String password=request.getParameter("password");
        
         try {
			result= object.checklogin(name, password) ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(result == true){  
        	HttpSession session=request.getSession();  
            session.setAttribute("user",name); 
            session.setAttribute("password", password);
            request.getRequestDispatcher("home.jsp").include(request, response);  
        }else{  
            out.println("Sorry! Unable to login");  
            request.getRequestDispatcher("login.jsp").include(request, response);
        }  
          
        out.close();  
		
	}
	

}
