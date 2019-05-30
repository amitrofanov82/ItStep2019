package com.epam.mentoring.spring.core.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Session {

	private LocalDateTime time;
	private List<Integer> seats;
	
	public Session(){
		setTime(LocalDateTime.of(2017, 4, 7, 15, 0));
		setSeats(Arrays.asList(1, 2, 3, 4, 5));
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public List<Integer> getSeats() {
		return seats;
	}

	public void setSeats(List<Integer> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Session [time=");
		builder.append(time);
		builder.append(", seats=");
		builder.append(seats);
		builder.append("]");
		return builder.toString();
	}

}
