package lp2g23.biblioteca;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.Serializable;

public class Usuario extends Pessoa implements Serializable{

	// Atributos da classe Usuario (para além dos herdados de Pessoa)..
	private String adress;
	private int contador = 0;

	// Método para atribuir o endereço.
	public void setAdress(String newAdress){
		this.adress = newAdress;
	}

	// Método para retonar o endereço.
	public String getAdress(){
		return adress;
	}

	// Construtores da classe Usuário. 
	public Usuario(String nome, String sobrenome, int dia, int mes, int ano, String CPF, String adress){
		super(nome, sobrenome, dia, mes, ano, CPF);
		setAdress(adress);
	}

	public Usuario(String nome, String sobrenome, String dia, String mes, String ano, String CPF, String adress){
		super(nome, sobrenome, dia, mes, ano, CPF);
		setAdress(adress);
	}

	// ArrayList que funciona como histórico do usuário, armazenando os livros que pegou emprestado (objetos da classe Emprest)
	// suas datas de empréstimo e datas de devolução.
	protected ArrayList<Emprest> hist = new ArrayList<Emprest>();

	// Método para se adicionar uma nova entrada no histórico do usuário, possuindo três assinaturas.
	public void addLivroHist(String dia, String mes, String ano, int codLivro){
		Emprest livro = new Emprest(dia, mes, ano, codLivro);
		hist.add(livro);
		Conta();
	}
	public void addLivroHist(int dia, int mes, int ano, int codLivro){
		Emprest livro = new Emprest(dia, mes, ano, codLivro);
		hist.add(livro);
		Conta();
	}
	public void addLivroHist(GregorianCalendar data, int codLivro){
		Emprest livro = new Emprest(data, codLivro);
		hist.add(livro);
		Conta();
	}
	
	// Método para contar quando uma nova entrada no histórico do usuário é realizada.
	public void Conta(){
		this.contador++;
	}

	// Método para retornar o número de entradas no histórico do usuário existem.
	public int getContador(){
		return contador;
	}
	
	// Método para retornar o histórico do usuário.
	public String getHist(){
		return hist.toString();
	}
	
	// Método toString da classe Usuário
	public String toString(){
		return super.toString() +
			"\nEndereço: " + getAdress() +
			"\nHistórico: " + getHist();
	}


}

