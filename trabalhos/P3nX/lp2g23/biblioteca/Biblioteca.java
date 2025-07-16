package lp2g23.biblioteca;
import lp2g23.excp.*;
import java.util.Hashtable;
import java.util.GregorianCalendar;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Biblioteca{
	// Criação de duas hashtables que servirão com banco de dados para cadastro de usuários e de livros.
	private Hashtable<String, Usuario> cadUsuario;
	private Hashtable<Integer, Livro> cadLivro;

	// Construtor da classe Biblioteca que inicializa os bancos de dados do zero, ou seja, cria uma 'nova' biblioteca.
	public Biblioteca(){
		this.cadUsuario = new Hashtable<>();
		this.cadLivro = new Hashtable<>();
	}

	public Hashtable<String, Usuario> getCadUsuario(){
		return cadUsuario;
	}
	public Hashtable<Integer, Livro> getCadLivro(){
		return cadLivro;
	}

	// Construtor da classe Biblioteca que carrega os bancos de dados a partir da leitura de dois arquivos passados como parâmetros.
	public Biblioteca(String arq1, String arq2) throws IOException, ClassNotFoundException{
		try{
			leArqUs(arq1);
			leArqLiv(arq2);
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}

	}
	
	// Método para cadastro de usuários no banco de dados cadUsuario.
	public static void cadastraUsuario(Hashtable<String, Usuario> cadUsuario, String CPF, Usuario user){
		if(cadUsuario.containsKey(CPF)){
			System.out.println("Erro: o CPF '" + CPF + "'já está cadastrado. Cadastro recusado.");
		}
		else{
			cadUsuario.put(CPF, user);
		}
	}

	// Método para cadastro de livros no banco de dados cadLivro
	public static void cadastraLivro(Hashtable<Integer, Livro> cadLivro, int codLivro, Livro livro){
		if(cadLivro.containsKey(codLivro)){
			System.out.println("Erro: o código '" + codLivro + "' já está cadastrado. Cadastro recusado.");
		}
		else{
			cadLivro.put(codLivro, livro);
		}
	}

	// Método para salvar em um arquivo o banco de dados de cadastro de usuários.
	public static void salvaArqUs(Hashtable<String, Usuario> cadUsuario, String nomeArq) throws IOException{
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArq));
			oos.writeObject(cadUsuario);
		}
		catch(IOException e){
			System.out.println("erro ao salvar o arquivo: " + e.getMessage());
		}
	}

	// Método para salvar em um arquivo o banco de dados de cadastro de livros.
	public static void salvaArqLiv(Hashtable<Integer, Livro> cadLivro, String nomeArq) throws IOException{
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArq));
			oos.writeObject(cadLivro);
		}
		catch(IOException e){
			System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
		}
	}

	// Método para leitura de arquivo que contenha o banco de dados de cadastro de usuários.
	public void leArqUs(String nomeArq) throws IOException, ClassNotFoundException{
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArq));
			Object obj = ois.readObject();
			
			if (obj instanceof Hashtable) {
			    	Hashtable<?, ?> tempUsuarios = (Hashtable<?, ?>) obj;
			    	Hashtable<String, Usuario> usuarios = new Hashtable<>();
			    	for (Map.Entry<?, ?> entry : tempUsuarios.entrySet()) {
					usuarios.put((String) entry.getKey(), (Usuario) entry.getValue());
			    	}

			    	this.cadUsuario = usuarios;
			} 
			else {
			    	System.out.println("Erro: tipo de dados no arquivo incorreto.");
			}
		}
		catch(IOException e){
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}
		catch (ClassNotFoundException e){
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}
	}

	// Método para leitura de arquivo que contenha o banco de dados de cadastro de livros.
	public void leArqLiv(String nomeArq) throws IOException, ClassNotFoundException{
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArq));
			Object obj = ois.readObject();
			if(obj instanceof Hashtable){
				Hashtable<Integer, Livro> livros = new Hashtable<>();
				livros.putAll((Hashtable<Integer, Livro>) obj);
				this.cadLivro = livros;
			}
			else{
				System.out.println("Erro: tipo de dados no arquivo incorreto.");
			}
		}
		catch (IOException e){
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}
		catch (ClassNotFoundException e){
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}
	}

	// Método para empréstimos de livros, registrando o empréstimo do livro e quem o tomou emprestado
	// no histórico do usuário e do livro, respectivamente.
	public void emprestaLivro(Usuario user, Livro book) throws CopiaNaoDisponivelEx{
		Usuario usuarioValido = getUsuario(user.getCPF());
		Livro livroValido = getLivro(book.getCodigo());
		
		try{
			livroValido.empresta();
			GregorianCalendar data = new GregorianCalendar();
			livroValido.addUsuarioHist(data, usuarioValido.getCPF());
			usuarioValido.addLivroHist(data.get(GregorianCalendar.DAY_OF_MONTH), 
					data.get(GregorianCalendar.MONTH),
					data.get(GregorianCalendar.YEAR), livroValido.getCodigo());
		}
		catch(CopiaNaoDisponivelEx e){
			System.out.println(e.getMessage());
		}
	}

	// Método para devolução de livro, registrando a data de devolução do livro nos históricos
	// do livro e no do usuário.
	public void devolveLivro(Usuario user, Livro book) throws NenhumaCopiaEmprestadaEx{
		Usuario usuarioValido = getUsuario(user.getCPF());
		Livro livroValido = getLivro(book.getCodigo());

		try{
			livroValido.devolve();
			GregorianCalendar data = new GregorianCalendar();
			for(Emprest livro: usuarioValido.hist){
				if(livro.getCodLivro() == book.getCodigo()){
					livro.setDataDevol(data);
				}
			}
			for(EmprestPara pessoa: livroValido.hist){
				if(pessoa.getCPF().equals(user.getCPF())){
					pessoa.setDataDevol(data);
				}
			}
		}
		catch(NenhumaCopiaEmprestadaEx e){
			System.out.println(e.getMessage());
		}	
	}

	// Método para retornar um objeto Usuário a partir do CPF que está atrelado a ele.
	public Usuario getUsuario(String CPF){
		return cadUsuario.get(CPF);
	}

	// Método para retornar um objeto Livro a partir do código que está associado a ele.
	public Livro getLivro(int cod){
		return cadLivro.get(cod);
	}

	// Método que retorna em uma String o cadastro de livros de uma biblioteca ordenado pelo valor
	// do código de cada livro, do menor para o maior.
	public String imprimeLivros(){
		StringBuilder str = new StringBuilder();
		ArrayList<Map.Entry<Integer, Livro>> cadLivroOrd = new ArrayList<>(cadLivro.entrySet());
		cadLivroOrd.sort(Map.Entry.comparingByKey());

		for(Map.Entry<Integer, Livro> valor: cadLivroOrd){
			str.append("Código: ").append(valor.getKey())
				.append(", Livro: ")
				.append(valor.getValue().getTitulo())
				.append("\n");
		}
		return str.toString();
	}

	// Método que retorna em uma String o cadastro de usuários de uma biblioteca ordenado pelo
	// CPF de cada usuário, do menor para o maior.
	public String imprimeUsuarios(){
		StringBuilder str = new StringBuilder();
		ArrayList<Map.Entry<String, Usuario>> cadUsuarioOrd = new ArrayList<>(cadUsuario.entrySet());
		cadUsuarioOrd.sort(Map.Entry.comparingByKey());

		for(Map.Entry<String, Usuario> valor: cadUsuarioOrd){
			str.append("CPF: ").append(valor.getKey())
				.append(", Usuario: ")
				.append(valor.getValue().getNome())
				.append("\n");
		}
		return str.toString();
	}

}
