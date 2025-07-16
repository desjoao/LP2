public class ValidaNome{
	public static boolean isNome(String nome){
		if (!nome.matches("^[a-zA-Z\\s]*$")){
			System.out.println("Utilize apenas palavras que contenham letras (e barra de espaço, para nomes compostos.)");
			return false;
		}
		return true;
	}
}

