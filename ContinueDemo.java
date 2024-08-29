class ContinueDemo {
	public static void main(String[] args){

		String searchMe = "o pé do padre pedro é preto";
		// uso da função .length oara passar o tamanho do vetor
		// para uma variável.
		int max = searchMe.length();
		int numPs = 0;

		// Laço com i iterando de 0 até o tamanho do vetor - 1
		// com o objetivo de encontrar o caracter 'p' e soma
		// à variável numPs
		for (int i = 0; i < max; i++){
			if (searchMe.charAt(i) != 'p')
				continue;

			numPs++;
		}
		System.out.println("Found " + numPs + "p's in the string.");
	}
}
