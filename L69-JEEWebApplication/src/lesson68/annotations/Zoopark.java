package lesson68.annotations;

@Mammal(pawsColor = "blue", pawsAmt=1)
public class Zoopark {
	
	@Mammal(pawsColor = {"blue", "blue", "blue", "blue"})
	String ziraf = "vasya";
	
	
	//@Mammal нельзя, Таргет.Метод не стоит
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		int a = 5; 
	}

}
