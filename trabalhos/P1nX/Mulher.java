import java.util.GregorianCalendar;

public class Mulher extends Pessoa{
	private String genero;
	
	public void setGenero(String genero){
		if(!genero.toUpperCase().equals("F") && !genero.toUpperCase().equals("FEMININO")){
			throw new IllegalArgumentException("Gênero inválido.");
		}
		this.genero = genero;
	}
	
	
	public String getGenero(){
		return "Feminino";
	}


	public Mulher(String genero ,String nome, String sobrenome, int dia, int mes, int ano, String CPF, float peso, float altura){
		super(nome, sobrenome, dia, mes, ano, CPF, peso, altura);
		setGenero(genero);
	
	}

	public Mulher(String genero, String nome, String sobrenome, String dia, String mes, String ano, String CPF, float peso, float altura){
		super(nome, sobrenome, dia, mes, ano, CPF, peso, altura);
		setGenero(genero);
	}

	public String toString(){

	return 
			"---------------------" +
			"\nNome: " + getNome() +
			"\nSobrenome: " + getSobrenome() +
			"\nGênero: " + getGenero() +
			"\nData de nascimento: " + getAniversario().get(GregorianCalendar.DAY_OF_MONTH) + 
			"/" + (getAniversario().get(GregorianCalendar.MONTH)+1) + 
			"/" + getAniversario().get(GregorianCalendar.YEAR) +
			"\nIdade: " + getIdade() +
			"\nAltura: " + getAltura() +
			"\nPeso: " + getPeso() +
			"\nCPF: " + getCPF();
	}
}

