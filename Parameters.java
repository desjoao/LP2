import java.util.Scanner;

public class Parameters{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String text = scan.nextLine();
		sayHi();
		printText(text);
	}

	public static void sayHi(){
		System.out.println("hi.");
	}

	public static void printText(String s){
		System.out.println(s);
	}
}
