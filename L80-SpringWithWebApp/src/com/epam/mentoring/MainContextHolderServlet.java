package com.epam.mentoring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.epam.mentoring.spring.core.configuration.BaseBeansConfiguration;
import com.epam.mentoring.spring.core.configuration.ProdBeansConfiguration;
import com.epam.mentoring.spring.core.configuration.TestBeansConfiguration;
import com.epam.mentoring.spring.core.model.User;
import com.epam.mentoring.spring.core.service.ReservationService;
import com.epam.mentoring.spring.core.service.impl.AuthService;

//@Component
@WebServlet("/SpringTestServlet")
public class MainContextHolderServlet extends HttpServlet {
	
	//@Autowired
	ReservationService reservationService 
		= WebApplicationContextUtils
		.getRequiredWebApplicationContext(this.getServletContext())
		.getBean(ReservationService.class);
			/*WebAppSpringContextHolder.context.getBean(ReservationService.class);*/
	AuthService authService = 
			WebAppSpringContextHolder.context.getBean(AuthService.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		if (req.getSession().getAttribute("authorised") != null){
			//Object o = reservationService.find("12345");
			//resp.getOutputStream().print("<h1>" + o + "</h2>");
		} else {
			String user = req.getParameter("user");
			String psw = req.getParameter("psw");
			User u = authService.getUserBy(user, psw.hashCode());
			// if u != null pu to session, else redirect login... 
		}
		
		Object o = reservationService.find("12345");
		resp.getOutputStream().print("<h1>" + o + "</h2>");

	}

	
}
