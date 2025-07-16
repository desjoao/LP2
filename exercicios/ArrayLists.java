import java.util.ArrayList;

public class ArrayLists{
	public static void main(String[] args){

		String [] frutas = new String [3];
		frutas[0] = "Manga";
		frutas[1] = "Banana";
		frutas[2] = "Maracujá";
		System.out.println(frutas[1]);

		ArrayList frutaLista = new ArrayList();
		frutaLista.add("Manga");
		frutaLista.add("Uva");
		frutaLista.add("Morango");
		System.out.println(frutaLista);
		frutaLista.remove("Morango");
		System.out.println(frutaLista);

	}
}
