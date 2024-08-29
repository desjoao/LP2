// import the Scanner function from java.util
import java.util.Scanner;

public class BooleanInJava{

	public static void main(String[] args){
		
		// Define the scan function as an objetct
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Inform an integer number: ");
		int a = scan.nextInt();
		boolean b = (a == 1);
		System.out.println("Is the number informed equals to 1?");
		System.out.println(b);
	}
}
