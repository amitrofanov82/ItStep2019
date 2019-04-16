package lesson70.forward_include;

import java.io.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  

@WebServlet("/servlet2")
public class WelcomeServlet extends HttpServlet {  

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("userName");  
	    out.print("Welcome "+n);  
    }  
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String n=request.getParameter("userName");  
		    out.print("Welcome "+n);  
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		switch(method) {
		case "GET":	
			doGet(req, resp);
		case "POST":
			doPost(req, resp);
		case "DELETE":
			doDelete(req, resp);
		default:
			throw new ServletException(method + " HTTP method not supported");	
		
		}
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service((HttpServletRequest) arg0, (HttpServletResponse) arg1);
	}
	
	
	
	
	
	
  
}  