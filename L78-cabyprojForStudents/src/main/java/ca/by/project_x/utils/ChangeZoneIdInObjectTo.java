package ca.by.project_x.utils;

import java.lang.reflect.Field;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ChangeZoneIdInObjectTo {
	public static void convertZonedTimeFieldsTo (ZoneId toZone, Object object) throws IllegalArgumentException, IllegalAccessException, InterruptedException {
		Class<?> clazz = object.getClass();
		if((clazz.getName().equals("java.lang.Object")) == false) {
			searchAndChangeZonedDateTime (clazz, toZone, object);
		}		
	}
	
	public static void convertZonedTimeFieldsWithSuperClassTo (ZoneId toZone, Object object) throws IllegalArgumentException, IllegalAccessException, InterruptedException {
		Class<?> clazz = object.getClass();
		if((clazz.getName().equals("java.lang.Object")) == false) {
			searchAndChangeZonedDateTime (clazz, toZone, object);
			convertZonedTimeFieldsToSuperClasses (clazz, toZone, object);
		}
	}
	
	public static void convertZonedTimeFieldsWithSubClassTo (ZoneId toZone, Object object) throws IllegalArgumentException, IllegalAccessException, InterruptedException {
		Class<?> clazz = object.getClass();
		if((clazz.getName().equals("java.lang.Object")) == false) {
			searchAndChangeZonedDateTime (clazz, toZone, object);
		}
		Field [] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if(field.toString().equals("public " + field.getType().getName() + " " + clazz.getName() + "." + field.getName())) {
				if (field.get(object) != null) {
					Object subObject = field.get(object);
					convertZonedTimeFieldsTo (toZone, subObject);				
				}
			} else {
				field.setAccessible(true);
				if (field.get(object) != null) {
				Object subObject = field.get(object);
				convertZonedTimeFieldsTo (toZone, subObject);				
				}
				field.setAccessible(false);
			}
		}		
	}
	
	private static void convertZonedTimeFieldsToSuperClasses (Class<?> clazz, ZoneId toZone, Object object) throws IllegalArgumentException, IllegalAccessException {
		Class<?> superClazz = clazz.getSuperclass();
		if((superClazz.getName().equals("java.lang.Object")) == false) {
			searchAndChangeZonedDateTime (superClazz, toZone, object);
			convertZonedTimeFieldsToSuperClasses (superClazz, toZone, object);
		}		
	}
	
	private static ZonedDateTime changeZoneId(ZonedDateTime dateTime, ZoneId toZone) {
		int year = dateTime.getYear();
		int month = dateTime.getMonthValue();
		int dayOfMonth = dateTime.getDayOfMonth();
		int hour = dateTime.getHour();
		int minute = dateTime.getMinute();
		int second = dateTime.getSecond();
		int nanoOfSecond = dateTime.getNano();
		dateTime = ZonedDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, toZone);
		return dateTime;
	}
	
	private static void searchAndChangeZonedDateTime (Class<?> clazz, ZoneId toZone, Object object) throws IllegalArgumentException, IllegalAccessException {
		ZonedDateTime changeDateTime;
		Field [] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			String type = field.getType().toString();
			if(type.equals("class java.time.ZonedDateTime")) {
				if(field.toString().equals("public java.time.ZonedDateTime " + clazz.getName() + "." + field.getName())) {
					changeDateTime = (ZonedDateTime) field.get(object);
					field.set(object, ChangeZoneIdInObjectTo.changeZoneId(changeDateTime, toZone));
				} else {
					field.setAccessible(true);
					changeDateTime = (ZonedDateTime) field.get(object);
					field.set(object, ChangeZoneIdInObjectTo.changeZoneId(changeDateTime, toZone));
					field.setAccessible(false);
				}
			}
		}
	}
}
