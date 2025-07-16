import java.util.Random;

public class FortuneCookie {

	static String[] fortunes = {"A vida trará coisas boas se tiver paciência.", 
		"Demonstre amor e alegria em todas as oportunidades e verá que a paz nasce dentro de si.", 
		"Não compense na ira o que lhe falta na razão.", 
		"Defeitos e virtudes são apenas dois lados da mesma moeda.", 
		"A maior de todas as torres começa no solo.", 
		"Não há que ser forte. Há que ser flexível.",
		"Melhor usar um desodorante mais forte."
		};

	public static void  main(String[] args) {
		Random rand = new Random();
		int num = rand.nextInt(fortunes.length);
		System.out.println(fortunes[num]);
	}
}
