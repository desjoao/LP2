import java.util.Scanner;

public class Multiply{

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		System.out.println("Quanto é 13 x 7?");
		int a = scan.nextInt();

		if (a == 91) {
			System.out.println("Correto");
		}
		else{
			System.out.println("Errado");
		}
	}
}
