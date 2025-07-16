import java.util.GregorianCalendar;
import java.util.Calendar;

public class TestePessoa{
	public static void main(String[] args) throws NullPointerException{

		System.out.println("Número de instâncias: " + Pessoa.numPessoas());

		Pessoa pessoa_1 = new Pessoa("João Pedro", "Guedes", "17", "dezembro", "1996");
		System.out.println(pessoa_1.toString() + "\nNúmero de instâncias: " + Pessoa.numPessoas());
		Pessoa pessoa_2 = new Pessoa("Marcia", "Matheos", 28, 06, 1971, "09316860679", 75.0F, 1.75F);	
		System.out.println(pessoa_2.toString() + "\nNúmero de instâncias: " + Pessoa.numPessoas());
		Homem homem = new Homem("João", "Chaves", 17, 12, 1996, "093.168.606-79", 78.0F, 1.8F);
		System.out.println(homem.toString() + "\nNúmero de instâncias: "  + Pessoa.numPessoas());		

	}
}
