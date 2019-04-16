package lesson68.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Example1
 */
@WebServlet({"/Example1"})
public class Example1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = req.getServletContext();
		sc.setAttribute("someKeyAtServletContext", "someValue");
		sc.getAttribute("someKeyAtServletContext");
		
		//org.apache.catalina.core.ApplicationContext ac;
		
		req.setAttribute("someKeyAtReuestAttributes", "ahsgjafg");
		req.getAttribute("someKeyAtReuestAttributes");
		

		//RequestDipsatcher: 
	    String n= req.getParameter("userName");  
	    String p= req.getParameter("userPass");  
	          
	    if(p.equals("servlet")) {  
	        RequestDispatcher rd = req.getRequestDispatcher("servlet2");  
	        rd.forward(req, resp);  
	    }  
	    else{  
	        System.out.print("Sorry UserName or Password Error!");  
	        RequestDispatcher rd=req.getRequestDispatcher("/index.html");  
	        rd.include(req, resp);  
	                      
	    }  
	}  
		
}
    


















