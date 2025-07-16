import java.util.GregorianCalendar;
import java.lang.Math;

abstract class PessoaIMC extends Pessoa{
	
	protected float peso, altura;

	public PessoaIMC(String nome, String sobreNome, String dia, String mes, String ano, String CPF, float peso, float altura){		
		super(nome, sobreNome, dia, mes, ano, CPF);
		setPeso(peso);
		setAltura(altura);
	}
	
	public PessoaIMC(String nome, String sobreNome, int dia, int mes, int ano, String CPF, float peso, float altura){
		super(nome, sobreNome, dia, mes, ano, CPF);
		setPeso(peso);
		setAltura(altura);
	}


	public void setPeso(float peso){
		if (peso >=2 && peso <= 400)
			this.peso = peso;
		else
			this.peso = -1;
	}
	public float getPeso(){
		return peso;
	}

	public void setAltura(float altura){
		if (altura >= 0.2 && altura <= 3.00)
			this.altura = altura;
		else
			this.altura = -1;
	}
	public float getAltura(){
		return altura;
	}

	public float calculaIMC(){
		float altura = getAltura();
		float peso = getPeso();
		return peso/(altura*altura);
	}

	public int getIdade(){
                GregorianCalendar anoAtual = new GregorianCalendar();
                int  diff;
                diff = anoAtual.get(GregorianCalendar.YEAR) - getAniversario().get(GregorianCalendar.YEAR);
                if (getAniversario().get(GregorianCalendar.MONTH) > anoAtual.get(GregorianCalendar.MONTH) ||
                                (getAniversario().get(GregorianCalendar.MONTH) == anoAtual.get(GregorianCalendar.MONTH) &&
                                getAniversario().get(GregorianCalendar.DAY_OF_MONTH) > anoAtual.get(GregorianCalendar.DAY_OF_MONTH)))
                        diff --;
                return diff;
        }

	public abstract String resultIMC();

	public String toString(){
		return super.toString() 
			+ "\nPeso: " + getPeso() 
			+ "\nAltura: " + getAltura();
	}

}
