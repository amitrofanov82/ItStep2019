package com.epam.mentoring.spring.core.configuration;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epam.mentoring.spring.core.dao.ReservationDao;
import com.epam.mentoring.spring.core.dao.SessionDao;
import com.epam.mentoring.spring.core.dao.impl.ReservationDaoImpl;
import com.epam.mentoring.spring.core.dao.impl.SessionDaoImpl;
import com.epam.mentoring.spring.core.service.ReservationService;
import com.epam.mentoring.spring.core.service.SessionService;
import com.epam.mentoring.spring.core.service.impl.ReservationServiceImpl;
import com.epam.mentoring.spring.core.service.impl.SessionServiceImpl;

@Configuration
public class BaseBeansConfiguration {

	@Bean(/*name="SesSionService"*/)
	//@Scope(value="singleton")//prototype
	public SessionService sessionService() {
		return new SessionServiceImpl();
	}

	@Bean(/*autowire=Autowire.BY_TYPE*//*name= "vasya", autowire=Autowire.NO, initMethod="", destroyMethod=""*/)
	public ReservationService ReservationService() {
		ReservationService reservationService = new ReservationServiceImpl();
		reservationService.setReservationDao(reservationDao());
		return reservationService;
	}

	@Bean(initMethod = "init"/*, name="vasyaAkaSessionDao"*/)
	public SessionDao sessionDao() {
		return new SessionDaoImpl();
	}
	
	/*@Bean(initMethod = "init", name="vasyaAkaSessionDao2")
	public SessionDao sessionDao2() {
		return new SessionDaoImpl();
	}*/

	@Bean(destroyMethod = "destroy")
	public ReservationDao reservationDao() {
		return new ReservationDaoImpl();
	}
}
