package lesson70.forward_include;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  

//https://www.javatpoint.com/requestdispatcher-in-servlet
@WebServlet("/servlet1")
public class Login extends HttpServlet {  

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("userName");  
	    String p=request.getParameter("userPass");  
	          
	    if(p.equals("servlet")){  
	        RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
	        rd.forward(request, response);  
	    } else {  
	        out.print("Sorry UserName or Password Error!");  
	        RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
	        rd.include(request, response);              
	    }  
    }  
  
}  





















