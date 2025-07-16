public class ValidaGenero{
	public static boolean isGenero(String genero){
		String g = genero.toUpperCase();
		if(g.equals("M") || g.equals("MASCULINO") || g.equals("F") || g.equals("FEMININO"))
			return true;
		System.out.println("Valores válidos de gênero: [M - F] ou [Masculino - Feminino].");
		return false;
	}
	public static boolean isHomem(String genero){
		String g = genero.toUpperCase();
		if(g.equals("M") || g.equals("MASCULINO"))
			return true;
		return false;
	}
	public static boolean isMulher(String genero){
		String g = genero.toUpperCase();
		if(g.equals("F") || g.equals("FEMININO"))
			return true;
		return false;
	}
}

