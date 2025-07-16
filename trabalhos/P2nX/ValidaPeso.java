public class ValidaPeso{
	public static boolean isPeso(String peso){
		if (Float.parseFloat(peso)>=2.00 && Float.parseFloat(peso) <=400)
			return true;
		System.out.println("Valor válido para peso: [2.00 - 400.00].");
		return false;
	}
}

