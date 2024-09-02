public class StringMethods{
	public static void main(String[] args){

		String nome = "Morfeu Juca Junior";

		System.out.println(nome);
		System.out.println("Upper Case: " + nome.toUpperCase());
		System.out.println("Lower Case: " + nome.toLowerCase());
		System.out.println("First Char: " + nome.charAt(0));
		System.out.println("Length: " + nome.length());
		System.out.println("Last Char: " + nome.charAt(nome.length() -1));
		System.out.println("Substring: " + nome.substring(7, 11));
	}
}
