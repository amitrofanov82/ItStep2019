/**
 * 
 */
package com.simple.contact.util;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.simple.contact.entity.Contact;


/**
 * @author mitrofanov_a
 *
 */
public class CsvImporterTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.simple.contact.util.CsvImporter#importCsv(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testImportCsv() throws Exception {
		//Prepare
		//URL resUrl = this.getClass().getResource("/testData/correctCsvFile");
		//File file = new File(resUrl.toURI());
		//String filePathToTestData = file.getAbsolutePath();
		String filePathToTestData = "d:/Mitrofanov/correctCsvFile"; 
		
		//Run
		List<Contact> result = CsvImporter.importCsv(filePathToTestData);
		
		//Asserts
		Assert.assertEquals(2, result.size());
		
	}
	
	@Test
	public void passedTest() {
		Assert.assertTrue(3>2);
	}
	
	/**
	 * Test method for {@link com.simple.contact.util.CsvImporter#importCsv(java.lang.String)}.
	 */
	@Test
	public void failedTest() {
		Assert.assertFalse(3>2);
		//fail("Not yet implemented"); 
	}
	
	@Test
	public void exceptionalTest() {
		throw new RuntimeException();
	}

}
