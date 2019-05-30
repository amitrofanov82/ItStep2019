package com.epam.mentoring.spring.core.main;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.mentoring.spring.core.configuration.BaseBeansConfiguration;
import com.epam.mentoring.spring.core.configuration.ProdBeansConfiguration;
import com.epam.mentoring.spring.core.configuration.TestBeansConfiguration;
import com.epam.mentoring.spring.core.model.Session;
import com.epam.mentoring.spring.core.service.ReservationService;
import com.epam.mentoring.spring.core.service.SessionService;

public class ExecutorXmlBased {

	private static final Logger logger = Logger.getLogger(ExecutorXmlBased.class);

	// To specify active profile use VM argument:
	// -Dspring.profiles.active="profile_name"
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context 
			= new ClassPathXmlApplicationContext("Beans.xml");

		SessionService sessionService = context.getBeanFactory().getBean(SessionService.class);
		ReservationService reservationService = context.getBean(ReservationService.class);
		List<Session> allSessions = sessionService.findAll(LocalDateTime.of(2017, 4, 7, 15, 0));
		System.out.println("!!!Find session result: " + allSessions);
		System.out.println("!!!Reservation after find method call: " + reservationService.find("12345"));
		reservationService.delete("12345");
		System.out.println("!!!Reservation after delete and find method call: " + reservationService.find("12345"));
		context.close();
	}
}



//https://www.googleapis.com/customsearch/v1

























