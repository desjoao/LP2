import java.util.Scanner;

public class ReturnStatements{
	public static void main(String[] args){

		printAMessage();
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite um número:");
		int a = scan.nextInt();
		System.out.println("Por qual número gostaria de somá-lo?");
		int b = scan.nextInt();
		System.out.println("O resultado é: " + Soma(a, b));
		System.out.println("Digite uma frase que gostaria de gritar.");
		String gritar = scan.nextLine();
		System.out.println(capsLock(gritar));
	}

	public static void printAMessage(){
		System.out.println("Esse é um programa para exercício de 'Return Statements'.");
	}

	public static int Soma(int a, int b){
		return a + b;
	}

	public static String capsLock(String s){
		return s.toUpperCase();
	}

	public static String lowerCaseOnly(String s){
		return s.toLowerCase();
	}
}
