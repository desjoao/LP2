import java.util.Scanner;
import java.util.Random;

public class EightBall {
	public static void main (String[] args) {

		Scanner scan = new Scanner(System.in);
        	Random rand = new Random();
		System.out.println("Insira a sua questão");
		scan.next();
		scan.close();

		int r = rand.nextInt(5);
   
        if (r == 0) {
		    System.out.println("Segundo os astros, sim.");
        }
        else if (r == 1) {
		    System.out.println("É o que tudo indica.");
        }
        else if (r == 2) {
		    System.out.println("Difícil dizer, pergunte de outra maneira.");
        }
        else if (r == 3) {
		    System.out.println("Não me parece que sim.");
        }
        else if (r == 4) {
		    System.out.println("Definitivamente não.");
        }	

	}
}
