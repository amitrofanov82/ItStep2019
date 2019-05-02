import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jV2Example {
	
	//static Logger log = LogManager.getLogger();
	//static Logger log = LogManager.getLogger(ArrayList.class);
	static Logger log = LogManager.getLogger(Log4jV2Example.class);
	
	public static void main(String[] args) {
		log.trace("trace hi");
		log.debug("debug hi");
		log.log(Level.INFO, "info hi");
		log.warn("warn hi");
		log.error("error hi");
		log.fatal("fatal hi");
		
		Log4jV2SomeOtherClass.main(null);
		
		/*System.out.println(log.getLevel());
		System.out.println(log.getName());
		System.out.println(log.isDebugEnabled());*/
		

	}
	
}


















