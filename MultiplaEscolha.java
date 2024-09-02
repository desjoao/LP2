import java.util.Scanner;

public class MultiplaEscolha{
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);

		String[] answers = {"c", "d", "c"};
		String[] responses = {"", "", ""};

		System.out.println("Quanto é 2 + 2?");
		System.out.println("a) 2 \nb) 3 \nc) 4 \nd) 5 \n");

		System.out.println("Qual é a capital do Rio de Janeiro?");
		System.out.println("a) Niterói \nb) Salvador \nc) Recife \nd) Rio de Janeiro \n");

		System.out.println("Qual é o anima mais rápido?");
		System.out.println("a) Tigre \nb) Gato \nc) Onça pintada \nd) Leão");

		responses[0] = scan.next();
		responses[1] = scan.next();
		responses[2] = scan.next();

		int score = 0;

		for (int i = 0; i < 3; i++){
			if (responses[i].equalsIgnoreCase(answers[i])) {
				score ++;
			}
		}
		System.out.println("Resultado: " + score + "/3");
	}
}
