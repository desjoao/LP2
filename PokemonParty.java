import java.util.Scanner;

public class PokemonParty{
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);

		System.out.println("Digite o nome de um pokémon: ");
		String pokemon1 = scan.nextLine();

		System.out.println("Digite o nome de um pokémon: ");
		String pokemon2 = scan.nextLine();

		System.out.println("Digite o nome de um pokémon: ");
		String pokemon3 = scan.nextLine();

		System.out.println("Digite o nome de um pokémon: ");
		String pokemon4 = scan.nextLine();

		System.out.println("Digite o nome de um pokémon: ");
		String pokemon5 = scan.nextLine();

		System.out.println("Digite o nome de um pokémon: ");
		String pokemon6 = scan.nextLine();

		System.out.println(pokemon1 + " " + pokemon2 + " " + pokemon3 + " " + pokemon4 + " " + pokemon5 + " " + pokemon6 + " se encontram na festa.");
	}
}
