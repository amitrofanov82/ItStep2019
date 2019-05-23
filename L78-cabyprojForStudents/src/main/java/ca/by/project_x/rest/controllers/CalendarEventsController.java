package ca.by.project_x.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.by.project_x.rest.dto.Event;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

//TODO delete after becomes useless
@RestController
@RequestMapping("/testapi/calendar")
@Slf4j
public class CalendarEventsController {


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path="/all")
    public ResponseEntity<List<Event>> getAll() throws IOException {
        log.debug("get all calendar events");
        List<Event> eventAll = new ArrayList<>(6);
        Event event1 = new Event(ZonedDateTime.of(LocalDate.now().getYear(), 9, 02, 00, 00, 00, 00, ZoneId.ofOffset("", ZoneOffset.ofHours(-3))), "Serious Day", "That day everything was serious...");
        Event event2 = new Event(ZonedDateTime.of(LocalDate.now().getYear(), 9, 03, 00, 00, 00, 00, ZoneId.ofOffset("", ZoneOffset.ofHours(-3))), "Rowan Bonfires Day", "I will turn the calendar, and there's 3rd of september again...");
        Event event3 = new Event(ZonedDateTime.of(LocalDate.now().getYear(), 10, 04, 18, 00, 00, 00, ZoneId.ofOffset("", ZoneOffset.ofHours(-3))), "Montreal Fair 2018", "most popular annual event for crafters");
        Event event4 = new Event(ZonedDateTime.of(LocalDate.now().getYear(), 10, 22, 23, 00, 00, 00, ZoneId.ofOffset("", ZoneOffset.ofHours(-3))), "Montreal Not Fair 2018", "not popular at all monthly event for who knows whom");
        Event event5 = new Event(ZonedDateTime.of(LocalDate.now().getYear(), 10, 30, 23, 00, 00, 00, ZoneId.ofOffset("", ZoneOffset.ofHours(-3))), "HAPPY HALLOWEEN!", "Happy Halloween, Happy Halloween, HAL-LO-WEEN HAL-LO-WEEN");
        Event event6 = new Event(ZonedDateTime.of(LocalDate.now().getYear(), 12, 06, 11, 00, 00, 00, ZoneId.ofOffset("", ZoneOffset.ofHours(-3))), "Lorem Ipsum party", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ");
                
        eventAll.addAll(Arrays.asList(new Event[]{event1, event2, event3, event4, event5, event6}));
        
        return new ResponseEntity<>(eventAll, HttpStatus.OK);
    }
	
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path="/upcoming")
    public ResponseEntity<List<Event>> getUpcoming() throws IOException {
        log.debug("get upcoming calendar events");
        List<Event> eventUpcoming = new ArrayList<>(6);
        Event event1 = new Event(ZonedDateTime.of(LocalDate.now().getYear(), 9, 03, 00, 00, 00, 00, ZoneId.ofOffset("", ZoneOffset.ofHours(-3))), "Rowan Bonfires Day", "I will turn the calendar, and there's 3rd of september again...");       
        Event event2 = new Event(ZonedDateTime.of(LocalDate.now().getYear(), 10, 04, 18, 00, 00, 00, ZoneId.ofOffset("", ZoneOffset.ofHours(-3))), "Montreal Fair 2018", "most popular annual event for crafters");
        Event event3 = new Event(ZonedDateTime.of(LocalDate.now().getYear(), 10, 22, 16, 30, 00, 00, ZoneId.ofOffset("", ZoneOffset.ofHours(-3))), "Montreal Not Fair 2018", "not popular at all monthly event for who knows whom");
        Event event4 = new Event(ZonedDateTime.of(LocalDate.now().getYear(), 10, 30, 00, 00, 00, 00, ZoneId.ofOffset("", ZoneOffset.ofHours(-3))), "HAPPY HALLOWEEN!", "Happy Halloween, Happy Halloween, HAL-LO-WEEN HAL-LO-WEEN");
        
        eventUpcoming.addAll(Arrays.asList(new Event[]{event1, event2, event3, event4}));
        
        return new ResponseEntity<>(eventUpcoming, HttpStatus.OK);
    }
}
