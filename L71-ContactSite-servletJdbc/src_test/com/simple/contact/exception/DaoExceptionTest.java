package com.simple.contact.exception;


public class DaoExceptionTest {

	public static void main(String[] args) {
		System.out.println("TEST1: " + 
				testConstructorWithHddenExceptionSavesException());
		System.out.println("TEST2: " + test2());
	}
	
	public static boolean testConstructorWithHddenExceptionSavesException() {
		//Prepare test data
		Exception hiddenException = new Exception("test data");
		String msg = "Message to test DaoException constructor";
		DaoException testedObject;
		
		//Emulate tested behaviour 
		testedObject = new DaoException(msg, hiddenException);
		
		//Check results
		if (testedObject.getHiddenException() == hiddenException){
			return true;
		} else {
			return false;
		}
		
		
	}
	
	public static boolean test2() {
		
		return true;
	}

}
