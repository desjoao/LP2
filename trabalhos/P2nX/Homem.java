import java.util.GregorianCalendar;

public class Homem extends PessoaIMC{
	public String getGenero(){
		return "Masculino";
	}

	@Override 
	public String resultIMC(){
	       if (calculaIMC() < 20.7)
		       return "Abaixo do peso ideal.";
	       else if(calculaIMC() <= 26.4)
		       return "Peso ideal.";
	       else
		       return "Acima do peso ideal.";
	}	       


	public Homem(String nome, String sobrenome, int dia, int mes, int ano, String CPF, float peso, float altura){
		super(nome, sobrenome, dia, mes, ano, CPF, peso, altura);				
	}
	public Homem(String nome, String sobrenome, String dia, String mes, String ano, String CPF, float peso, float altura){
		super(nome, sobrenome, dia, mes, ano, CPF, peso, altura);
	}

	public String toString(){

	return	super.toString() +
		"\nGênero: " + getGenero() +
		"\nIdade: " + getIdade()+
		"\nIMC: " + calculaIMC() + ", " + resultIMC();
	}
}

