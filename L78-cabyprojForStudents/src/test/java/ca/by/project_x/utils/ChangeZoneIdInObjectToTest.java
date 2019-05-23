package ca.by.project_x.utils;

import static org.junit.Assert.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

import lombok.Data;

public class ChangeZoneIdInObjectToTest {
	
	private final static String TEST_ISO8601_DATETIME_UTC_STRING = "2018-11-24T23:05:05Z"; 
	
	private ZoneId utcZone = ZoneId.of("UTC");
	private ZoneId minskZone = ZoneId.of("Europe/Minsk");
	private ZoneId torontoZone = ZoneId.of("EST", ZoneId.SHORT_IDS);
	
	@Data
	private static class SimpleObjectWithZonedDateTime {
		private String stringValue;
		private int intValue;
		private ZonedDateTime dateTime;
	}

	@Test
	public void testSimpleObjectConversion() throws Exception {
		SimpleObjectWithZonedDateTime testObject = new SimpleObjectWithZonedDateTime();
		testObject.setDateTime(ZonedDateTime.parse(TEST_ISO8601_DATETIME_UTC_STRING));
		
		ChangeZoneIdInObjectTo.convertZonedTimeFieldsTo(minskZone, testObject);
		int minsk24Hours = testObject.getDateTime().getHour();
		int minskDayOfMonth = testObject.getDateTime().getDayOfMonth();
		
		ChangeZoneIdInObjectTo.convertZonedTimeFieldsTo(torontoZone, testObject);
		int toronto24Hours = testObject.getDateTime().getHour();
		int torontoDayOfMonth = testObject.getDateTime().getDayOfMonth();
		
		
		assertTrue(minskDayOfMonth == 25);
		assertTrue(torontoDayOfMonth == 24);
		assertTrue((minsk24Hours - toronto24Hours) == 8 ||  (minsk24Hours - toronto24Hours) == 7); //there can be 7 or 8 dependent on winter/summer time
		
		ChangeZoneIdInObjectTo.convertZonedTimeFieldsTo(utcZone, testObject);
		//TODO: I'm not sure this test should pass. Call me, if above works, but fails here. Delete this comment, if it passes.
		assertEquals(testObject.getDateTime(), ZonedDateTime.parse(TEST_ISO8601_DATETIME_UTC_STRING)); 
		
	}

}
