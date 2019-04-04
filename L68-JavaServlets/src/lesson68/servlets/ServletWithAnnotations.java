package lesson68.servlets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
// Import required java libraries
import java.io.*;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.JFrame;

// Extend HttpServlet class
@WebServlet("/annotation")
public class ServletWithAnnotations extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
	
	private String message;
    private int visitorCounter = 0;

   @Override
   public void init() throws ServletException {
      // Do required initialization
      message = "ServletWithAnnotations Initialized at " + new Date();
      System.out.println(message); 
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	  
	  System.out.println("ServletWithAnnotations: New GET request"); 
      visitorCounter++;
      // Set response content type
      response.setContentType("text/html");
      //response.setHeader("content-type", "text/html");
 
      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("<h1>" + message + " counter = " + visitorCounter + "</h1>");
      //out.close();

   }

   @Override
   public void destroy() {
	   System.out.println("Servlet end of life"); 
	   System.out.println("Bifer retirement I served " + visitorCounter + "people"); 
   }
}
