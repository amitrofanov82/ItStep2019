package ca.by.project_x.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.by.project_x.rest.dto.locations.Country;
import ca.by.project_x.rest.dto.locations.District;
import ca.by.project_x.rest.dto.locations.Location;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/location")
@Slf4j
public class LocationsController {
 
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path="{id}")
    public ResponseEntity<Location> getLocation(@PathVariable Long id) {
		log.debug("get location method");
		
		Country c = new Country("US", "USA", "USA","United States of America");
		District d = new District("Washington", "WA", "state");
		Location location = new Location(1L, c, d, "Monreal", "city");
		
        return new ResponseEntity<>(location, HttpStatus.OK);
    }
	
}
