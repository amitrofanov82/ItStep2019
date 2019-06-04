package com.epam.mentoring;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.mentoring.spring.core.service.ReservationService;

//@WebListener
public class WebAppSpringContextHolder  implements ServletContextListener {

	static ConfigurableApplicationContext context;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("CONTEXT DESTROY LISTENER CALLED");
		context.close();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("CONTEXT INIT LISTENER CALLED");
		context = new ClassPathXmlApplicationContext("Beans.xml");
	}

}




















