import java.util.ArrayList;
import java.util.Scanner;

public class ForEachLoop{
	public static void main(String[] args){

		ArrayList<String> carros = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);

		int resp = 1;
		String carro = "";
		while (resp == 1){
			System.out.println("FEIRÃO DE CARROS USADOS");
			scan.nextLine();
			System.out.println("Informe o nome do carro.");
			carro = scan.nextLine();
			carros.add(carro);
			System.out.println("Gostaria de adicionar mais um carro? (0 - NÃO / 1 - SIM)");
			resp = scan.nextInt();
		}

		System.out.println("\n ----- SUA GARAGEM -----\n");
		for (String car: carros){
			System.out.println(car);
		}
	}
}
