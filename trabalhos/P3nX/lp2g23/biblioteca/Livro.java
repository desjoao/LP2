package lp2g23.biblioteca;
import lp2g23.excp.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.*;

public class Livro implements Serializable{

	// Atributos da classe Livro.
	private int codLivro;
	private String titLivro, categLivro;
	private int qnt;
       	private int numEmprest;
	private int numDisp;

	public Livro(int codLivro, String titLivro, int qnt, int numEmprest) throws IOException{
		try{
			setCodigo(codLivro);
			setTitulo(titLivro);
			setCategoria();
			setQuantidade(qnt);
			setEmprestados(numEmprest);
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	// Método para atribuir o código do livro.
	public void setCodigo(int codLivro){
		if (codLivro >=0 && codLivro <=999)
			this.codLivro = codLivro;
		else
			System.out.println("O código deve estar dentro do intervalo [0 - 999].");
	}

	// Método para retornar o código do livro.
	public int getCodigo(){
		return codLivro;
	}

	// Método para atribuir o título do livro.
	public void setTitulo(String titLivro){
		this.titLivro = titLivro;
	}
	
	// Método para retornar o título do livro.
	public String getTitulo(){
		return titLivro;
	}

	// Método para atribuir a categoria literária a qual o livro pertence.
	public void setCategoria() throws IOException{
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			for(Categoria cat: Categoria.values()){
				System.out.println(cat.toString());
			}
	
			System.out.println("\nInforme a categoria dentre as informadas acima: ");
			String categLivro = in.readLine();
			if (categLivro.matches("^[a-zA-Z]+$")){
				int n = 0;
       	                 for (Categoria cat: Categoria.values()){
       	                         if (categLivro.toUpperCase().equals(cat.toString())){
       	                                 this.categLivro = cat.toString();
       	                                 break;
       	                         }
				}
			}
			else
				this.categLivro = "OUTROS";
		}
		catch(IOException e){
			System.out.println("erro na inserção de dado: " + e.getMessage());
		}
	}

	// Método para retornar a categoria litirária a qual o livro pertence.
	public String getCategoria(){
		return categLivro;
	}

	// Método para atribuir a quantidade de exemplares do livro.
	public void setQuantidade(int qnt){
		if (qnt >=0)
			this.qnt = qnt;
		else
			this.qnt = 0;
	}

	// Método para retornar a quantidade de exemplares do livro.
	public int getQuantidade(){
		return qnt;
	}
	
	// Método para atribuir a quantidade de exemplares do livro que estão emprestados e a quantidade de exemplares que estão disponíveis.
	public void setEmprestados(int qntEmpresta){
		if(qntEmpresta>=0){
			this.numEmprest = qntEmpresta;
			this.numDisp = qnt - numEmprest;
		}
		else{
			System.out.println("Não é possível inserir número negativo, a quantidade de livros disponíveis foi marcada como zero.");
			this.numEmprest = 0;
		}
	}

	// Método para retornar a quantidade de exmeplares do livro que estão emprestados.
	public int getEmprestados(){
		return numEmprest;
	}

	// Método para retornar a quantidade de exemplares do livro que estão disponíveis
	public int getDisponivel(){
		return numDisp;
	}
	
	// Método de empréstimo, funciona para manipular o número de livros emprestados e disponíveis, lançando uma exceção caso
	// o método seja chamado mas não haja mais livros disponíveis para empréstimo.
	public void empresta() throws CopiaNaoDisponivelEx{
		if (numDisp > 0){
			this.numEmprest++;
			this.numDisp--;
		}
		else
			throw new CopiaNaoDisponivelEx("Não há cópias disponíveis para empréstimo.");
	}

	// Método de devolução, funciona para manipular o número de livros emprestados e disponíveis, lançando uma exceção caso
	// o método seja chamado mas não haja mais livros emprestados para serem devolvidos.
	public void devolve() throws NenhumaCopiaEmprestadaEx{
		if (numEmprest > 0){
			this.numEmprest--;
			this.numDisp++;
		}
		else
			throw new NenhumaCopiaEmprestadaEx("Nenhuma cópia foi emprestada.");
	}

	// ArrayList que funciona como histórico do livro, guardando informações sobre quando o livro foi emprestado,
	// quando foi devolvido e por quem ele foi emprestado.
	protected ArrayList<EmprestPara> hist = new ArrayList<EmprestPara>();	

	/* Método para adicionar as informações no histórico do livro, possuindo duas assinaturas,
 	   uma para quando se quer adcionar a data de devolução, outra para quando o livro ainda
	   não tenha sido devolvido. */
	public void addUsuarioHist(GregorianCalendar dataLocaçao, GregorianCalendar dataDevoluçao, String CPF){
	       if (ValidaCPF.isCPF(CPF)){
		       hist.add(new EmprestPara(dataLocaçao, dataDevoluçao, CPF));
	       }
	}
	public void addUsuarioHist(GregorianCalendar dataLocaçao, String CPF){
		if (ValidaCPF.isCPF(CPF))
			hist.add(new EmprestPara(dataLocaçao, CPF));
	}

	// Método para retornar o histórico do livro.
	public String getHist(){
		return hist.toString();
	}

	// Método toString da classe Livro.
	public String toString(){
		return "Código: " + getCodigo()	+
			"\nTítulo: " + getTitulo() +
			"\nCategoria: " + getCategoria() +
			"\nNúmero de cópias: " + getQuantidade() +
			"\nQuantidade disponível: " + getDisponivel() +
			"\nQuantiadade emprestada: " + getEmprestados() +
			"\nHistórico: " + getHist();
	}
}
