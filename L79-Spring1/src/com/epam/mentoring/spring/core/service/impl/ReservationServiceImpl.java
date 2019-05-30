package com.epam.mentoring.spring.core.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.epam.mentoring.spring.core.dao.ReservationDao;
import com.epam.mentoring.spring.core.exception.ServiceException;
import com.epam.mentoring.spring.core.model.Reservation;
import com.epam.mentoring.spring.core.service.ReservationService;

@Component
public class ReservationServiceImpl implements ReservationService {

	private static final Logger logger = Logger.getLogger(ReservationServiceImpl.class);

	@Autowired
	private ReservationDao reservationDao;

	public void delete(String number) {
		if (StringUtils.isEmpty(number)) {
			logger.error("Illegal argument. Cannot delete reservation: reservation number null or empty");
			throw new ServiceException("Cannot delete reservation");
		}
		reservationDao.delete(number);
	}

	public Reservation find(String number) {
		if (StringUtils.isEmpty(number)) {
			logger.error("Illegal argument. Cannot find reservation: reservation number null or empty");
			throw new ServiceException("Cannot find reservation");
		}
		return reservationDao.find(number);
	}

	public ReservationDao getReservationDao() {
		return reservationDao;
	}

	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

}
