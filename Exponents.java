import java.util.Scanner;

public class Exponents {
	public static void main (String[] args){

		Scanner scan = new Scanner(System.in);
		System.out.println("Insira um número que deseja elevar ao quadrado");
		int a = scan.nextInt();
		System.out.println((int)Math.pow(a, 2));
	}
}
