
public class SelfMadeLogger {
	
	//setting field
	
	static {
		//read setting from file
	}
	
	public static void log(String message) {
		if (System.getProperty("user").equals("Alexey")){
			System.out.println(message);
		}
	}
	
	//a lot of additional convinient methods
	
	
	
}
