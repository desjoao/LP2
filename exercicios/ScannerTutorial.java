import java.util.Scanner;

public class ScannerTutorial{

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Qual é seu primeiro nome?");
		String primeiroNome = scan.next();

		System.out.println("Qual é sua idade?");
		int idade = scan.nextInt();
		
		System.out.println("Informe sua frase de formatura:");
		String frase = scan.next();
		frase += scan.nextLine();

		System.out.println("Obrigado " + primeiroNome + ", você tem " + idade + " anos e a sua frase de formatura é: " + frase);
 
	}
}
