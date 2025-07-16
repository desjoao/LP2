import java.util.Scanner;

public class Methods {
	public static void main(String[] args){

	Scanner scan = new Scanner(System.in);
	System.out.println("Olá, digite um número:");
	int a = scan.nextInt();
	System.out.println("Por qual número gostaria de multiplicá-lo?");
	int b = scan.nextInt();
	System.out.print("O resultado é: ");
	multiply(a, b);

	}
	public static void multiply(int a, int b){
		System.out.println(a * b);
	}
}
