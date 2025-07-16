import java.util.Scanner;

public class ComparisonOperators{
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);

		// == is equal to
		// != is not equal to
		// <= less than or equal to
		// < less than
		// >= greater than or equal to
		// greater than
		// || or
		// && and


		System.out.println("Insira um número inteiro: ");
		int num = scan.nextInt();

		if (num >=0 && num <= 10){
			System.out.println("O valor está entre 0 e 10.");
		}
		else if (num > 10){
			System.out.println("O valor é maior do que 10.");
		}
		else{
			System.out.println("O valor é negativo.");
		}
	}
}
