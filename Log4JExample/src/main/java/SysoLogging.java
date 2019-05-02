import java.io.FileOutputStream;
import java.io.PrintStream;

public class SysoLogging {
	
	public static void main(String[] args) {
		System.out.println("Hello log");
		//System.out = new PrintStream(new FileOutputStream("./file.out"));
		System.out.println("Hello log");
		
		SelfMadeLogger.log("Hello Alexey");
	}

	
	
}
