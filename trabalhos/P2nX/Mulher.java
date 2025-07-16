import java.util.GregorianCalendar;

public class Mulher extends PessoaIMC{
	
	public String getGenero(){
		return "Feminino";
	}

	@Override 
	public String resultIMC(){
	       if (calculaIMC() < 19)
		       return "Abaixo do peso ideal.";
	       else if(calculaIMC() <= 25.8)
		       return "Peso ideal.";
	       else
		       return "Acima do peso ideal.";
	}	       


	public Mulher(String nome, String sobrenome, int dia, int mes, int ano, String CPF, float peso, float altura){
		super(nome, sobrenome, dia, mes, ano, CPF, peso, altura);				
	}
	public Mulher(String nome, String sobrenome, String dia, String mes, String ano, String CPF, float peso, float altura){
		super(nome, sobrenome, dia, mes, ano, CPF, peso, altura);
	}

	public String toString(){

		return	super.toString() +
			"\nGênero: " + getGenero() +
			"\nIdade: " + getIdade()+
			"\nIMC: " + calculaIMC() + ", " + resultIMC();
	}
}

