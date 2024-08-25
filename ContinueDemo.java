class ContinueDemo {
	public static void main(String[] args){

		String searchMe = "o pé do padre pedro é preto";
		int max = searchMe.length();
		int numPs = 0;

		for (int i = 0; i < max; i++){
			if (searchMe.charAt(i) != 'p')
				continue;

			numPs++;
		}
		System.out.println("Found " + numPs + "p's in the string.");
	}
}
