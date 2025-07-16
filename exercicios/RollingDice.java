import java.util.Random;

public class RollingDice {
	public static void main(String[] args) {
		Random Dado = new Random(); 	
		int resultado = Dado.nextInt(6) + 1; 	

		System.out.println("Você jogou o dado...");
		System.out.println("E tirou um " + resultado);
	}
}

 
