import java.util.Scanner;

public class Adding{

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Quanto é 5 + 7?");
		int a = scan.nextInt();
		if (a == 12){
			System.out.println("Correto");
		}
		else {
			System.out.println("Errado");
		}
	}
}
