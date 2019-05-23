package ca.by.project_x;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;

public class BootApplication {

    public static void main(String[] args) {
    	TimeZone.setDefault( TimeZone.getTimeZone( "UTC" ) );
    	
        SpringApplication app = new SpringApplication(RootConfiguration.class);
        app.run(args);
    }

}
