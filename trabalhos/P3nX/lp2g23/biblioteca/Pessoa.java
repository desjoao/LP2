package lp2g23.biblioteca;
import java.util.Scanner;
import java.util.GregorianCalendar;

public class Pessoa{
	
	// Instâncias 
	private String nome, sobreNome;
	private GregorianCalendar dataNasc;
	private long numCPF;
	private float altura, peso;

	// Métodos getter e setter utilizados
	public void setNome(String novoNome){
		if(!novoNome.matches("^[0-9]+$")){
			this.nome = novoNome;
		}
		else{
			this.nome = "null";
		}	
	}
	public String getNome(){
		return nome;
	}

	public void setSobrenome(String novoSobrenome){
		if(novoSobrenome.matches("^[a-zA-Z]+$")){
			this.sobreNome = novoSobrenome;
		}
		else{
			this.sobreNome = "null";
		}
	}
	public String getSobrenome(){
		return sobreNome;
	}

	public void setAltura(float novaAltura){
		if(novaAltura >= 0.30 && novaAltura <= 3.00){
			this.altura = novaAltura;
		}
	}
	public float getAltura(){
		return altura;
	}

	public void setPeso(float novoPeso){
		if(novoPeso >= 2.00 && novoPeso <= 400.00){
			this.peso = novoPeso;
		}
	}
	public float getPeso(){
		return peso;
	}

	public void setAniversario(int dia, int mes, int ano){
		if (ValidaData.isDataValida(dia, mes, ano)){
			this.dataNasc = new GregorianCalendar(ano, mes -1, dia);
		}
		else{
			this.dataNasc = new GregorianCalendar();
		}
		
	}
	public void setAniversario(String dia, String mes, String ano){
		if(ValidaData.isDataValida(dia, mes, ano)){
			int d = Integer.parseInt(dia);
			int a = Integer.parseInt(ano);
			int m;
			if (mes.matches("^[a-zA-Z]+$")){
				for(Mes month: Mes.values()){	
					if (mes.toUpperCase().equals(month.toString())){
						m = month.getMesNumero() - 1;
						this.dataNasc = new GregorianCalendar(a, m, d);
						break;
					}
				}
				m = -1;
			}
			else{
				m = Integer.parseInt(mes);
				this.dataNasc = new GregorianCalendar(a, m -1, d);
			}
		}
		else{
			this.dataNasc = new GregorianCalendar();
		}
	}


	public GregorianCalendar getAniversario(){
		return dataNasc;
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

	public void setCPF(String cpf){
		if (ValidaCPF.isCPF(cpf)){
			this.numCPF = ValidaCPF.toLong(cpf);
		}
	}

	public String getCPF(){
		return ValidaCPF.imprimeCPF(numCPF);
	}
	public long getLongCPF(){
		return numCPF;
	}

	// Construtores
	public Pessoa(){	
		Incrementa();
	}
	public Pessoa(String nome, String sobrenome, int dia, int mes, int ano){
		setNome(nome);
		setSobrenome(sobrenome);
		setAniversario(dia, mes, ano);
		Incrementa();
	}

	public Pessoa(String nome, String sobrenome, String dia, String mes, String ano){
		setNome(nome);
		setSobrenome(sobrenome);
		setAniversario(dia, mes, ano);
		Incrementa();
	}

	public Pessoa(String nome, String sobrenome, int dia, int mes, int ano, String cpf){
		setNome(nome);
		setSobrenome(sobrenome);
		setAniversario(dia, mes, ano);
		setCPF(cpf);
		Incrementa();
	}
	
	public Pessoa(String nome, String sobrenome, String dia, String mes, String ano, String cpf){
		setNome(nome);
		setSobrenome(sobrenome);
		setAniversario(dia, mes, ano);
		setCPF(cpf);
		Incrementa();
	
	}	

	// Contador de instâncias
	private static int contador = 0;
	public void Incrementa(){
		this.contador ++;
	}

	//Método numPessoas
	public static int numPessoas(){
		return contador;
	}
	

	// Método toString	
	public String toString(){
		
		
		
		return 
			"---------------------" +
			"\nNome: " + getNome() +
			"\nSobrenome: " + getSobrenome() +
			"\nData de nascimento: " + getAniversario().get(GregorianCalendar.DAY_OF_MONTH) + 
			"/" + (getAniversario().get(GregorianCalendar.MONTH)+1) + 
			"/" + getAniversario().get(GregorianCalendar.YEAR) +
			"\nIdade: " + getIdade() +
			"\nCPF: " + getCPF();	
	}

}
