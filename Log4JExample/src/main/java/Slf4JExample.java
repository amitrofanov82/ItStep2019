import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4JExample {

	//static Logger log = LogManager.getLogger(Log4jV2Example.class);
	static Logger logger = LoggerFactory.getLogger(Slf4JExample.class);
	
	public static void main(String[] args) {
		logger.error("sad life", new RuntimeException("bye-bye"));
		
		
		
		
		logger.debug("debug message");
		logger.error("debug message");
		logger.info("debug message");
		logger.warn("debug message");
		
		try { 
			throw new RuntimeException("неожиданная опа");
		} catch (Exception e) {
			logger.error("debug message", e);
			logger.info("debug message", e);
			logger.warn("debug message", e);
		}
		
	}
	
}
