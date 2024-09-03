import java.util.Scanner;
import java.util.ArrayList;

public class WhileLoops{
	public static void main(String[] args){

		String frase = "Club de Regatas Vasco da Gama";
		Scanner scan = new Scanner(frase);
		ArrayList<String> palavras = new ArrayList<String>();

		while(scan.hasNext()){
			palavras.add(scan.next());
		}

		System.out.println(palavras);


	}
}
