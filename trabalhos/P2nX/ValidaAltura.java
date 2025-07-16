public class ValidaAltura{
	public static boolean isAltura(String altura){
		if (Float.parseFloat(altura) >= 0.40 && Float.parseFloat(altura) <= 3.00)
			return true;
		System.out.println("Valores válidos para altura: [0.40 - 3.00].");
		return false;
	}
}
