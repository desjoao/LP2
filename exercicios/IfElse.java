import java.util.Scanner;

public class IfElse {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("\n----- This is a program to evaluate if you passed in your class ----- \n\n\n ");
		System.out.println("Enter your grade:");

		int n = scan.nextInt();
		
		if (n >= 90 && n <= 100) {
			System.out.println("A");
			System.out.println("You've passed!");
		}
		else if (n >= 80) {
			System.out.println("B");
			System.out.println("You've passed!");
		}
		else if (n >= 70) {
			System.out.println("C");
			System.out.println("You've passed!");
		}
		else if (n >= 65) {
			System.out.println("D");
			System.out.println("You need to make the final test");
		}
		else if (n >= 0) {
			System.out.println("F");
			System.out.println("You've failed!");
		}
		else {
			System.out.println("Error, number not in the 0 - 100 range");
		}
	}
}
