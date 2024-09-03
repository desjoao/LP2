import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Criptografia{
	public static void main(String[] args) throws IOException, FileNotFoundException {


		System.out.println("Digite uma mensagem");
		Scanner in = new Scanner(System.in);

		int chave = 3;
		FileWriter writer = new FileWriter("[INSIRA O DIRETÓRIO AQUI]");

		String texto = in.nextLine();

		System.out.println("\nMensagem inicial: " + texto);


		char[] chars1 = texto.toCharArray();

		System.out.println("\nMensagem criptografrada.");

		for (char c: chars1){
			c += chave;
			System.out.print(c);
			writer.write(c);
		}

		writer.close();

		File file = new File ("[INSIRA O DIRETÓRIO AQUI]");

		Scanner scan = new Scanner(file);

		texto = "";

		while(scan.hasNextLine()){
			texto = texto.concat(scan.nextLine() + "\n");
		}

		char[] chars2 = texto.toCharArray();

		System.out.println("\n\nMensagem descriptografada");

		for (char c: chars2){
			c -= chave;
			System.out.print(c);
		}
		System.out.println();
	}
}
