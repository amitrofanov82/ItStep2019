package com.epam.mentoring.spring.core.main;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class ExperimentBean {
	
	public ExperimentBean(){
		System.out.println("---------------- EXPERIMENT BEAN CONSTRUCT -----------------" );
	}
}
