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
import javax.servlet.http.*;
import javax.swing.JFrame;

// Extend HttpServlet class
public class HWServlet extends HttpServlet {
 
   private String message;
   private int visitorCounter = 0;

   @Override
   public void init() throws ServletException {
      // Do required initialization
      message = "Servlet Initialized at " + new Date();
      System.out.println(message); 
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	   
	  //http://localhost:8080/OurFirstApp/servlets/AKSJFHKJHALKSJFH?option1=yes&option2=now
	  System.out.println(request.getRequestURI());
	  System.out.println("par" + request.getParameter("option1"));
	  System.out.println("attr:" + request.getAttribute("option1"));
	  System.out.println("allAtr: " + request.getAttributeNames());
	  System.out.println("allParam: " + request.getParameterNames());
	  System.out.println("queryString: " + request.getQueryString());
	 
	  
	  System.out.println("New GET request to HWServlet"); 
      // Set response content type
      response.setContentType("text/html");
      //response.setHeader("content-type", "text/html");
      
      /*JFrame fr = new FrameDemo2();
      fr.setBackground(Color.WHITE);
      fr.setSize(new Dimension(250, 300));
      fr.setTitle("Windows-Application");
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fr.setVisible(true);
      fr.repaint();
      System.out.println("okno sozdano");*/
      
      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("<h1>" + message + "</h1>");
      //out.close();
      visitorCounter++;
   }

   @Override
   public void destroy() {
	   System.out.println("Servlet end of life"); 
	   System.out.println("Bifer retirement I served " + visitorCounter + "people"); 
   }
}

class FrameDemo2 extends JFrame {
    private String msg = "My Windows-Application";

    public void paint(Graphics g) {
    	super.paint(g);
        //setSize(200, 205);
        Graphics2D g2 = (Graphics2D)g;
        setBackground(Color.LIGHT_GRAY);
        g2.rotate(Math.PI / 6);
        drawChessBoard(g);
        //пїЅпїЅпїЅпїЅпїЅпїЅпїЅ
        g2.rotate(-Math.PI / 6);
        g.setXORMode(new Color(200, 255, 250));
        Shape e = new Ellipse2D.Float(70, 75, 70, 50);
        //пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅ
        g2.fill(e);
    }

    public void drawChessBoard(Graphics g) {
        int size = 16;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if ((x + y) % 2 == 0)
                    g.setColor(Color.BLUE);
                else
                    g.setColor(Color.WHITE);
                g.fillRect(75 + x * size, y * size - 25, size, size);
            }
            g.setColor(Color.BLACK);

            g.drawString(new Character((char)('8' - y)).toString(), 66,
                         y * size - 13);
            g.drawString(new Character((char)(y + 'a')).toString(),
                         79 + y * size, 8 * size - 14);
        }
    }
}
