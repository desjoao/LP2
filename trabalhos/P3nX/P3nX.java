import lp2g23.biblioteca.*;
import lp2g23.excp.*;
import java.io.*;
import java.util.Hashtable;

public class P3nX implements Serializable{

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	protected static Biblioteca biblioteca;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, NenhumaCopiaEmprestadaEx, CopiaNaoDisponivelEx{
		try{
			iniciaPrograma();
		}
		catch (IOException e){
			System.out.println("Erro de input/output de dados: " + e.getMessage());
		}
		catch (ClassNotFoundException e){
			System.out.println("Erro de salvar/carregar arquivo: " + e.getMessage());
		}
	}

	public static void iniciaPrograma()throws IOException, ClassNotFoundException, NenhumaCopiaEmprestadaEx, CopiaNaoDisponivelEx{
			
		int resposta = 0;
		while(resposta != 1 && resposta != 2){
			System.out.println("[1] - Iniciar uma nova biblioteca." +
					"\n[2] - Carrega uma biblioteca existente.");
			resposta = Integer.parseInt(in.readLine());
			if (resposta != 1 && resposta != 2)
				System.out.println("Valor inválido.");
		}
		if (resposta == 1)
			novaBiblioteca();
		else{
			System.out.println("Insira o nome do arquivo de usuários: ");
			String arqUs = in.readLine();
			System.out.println("Insira o nome do arquivo de livros: ");
			String arqLiv = in.readLine();

			carregaBiblioteca(arqUs, arqLiv);
		}
	}
		
	public static void novaBiblioteca() throws IOException{
			
		biblioteca = new Biblioteca();
		Hashtable<Integer, Livro> cadLivro = biblioteca.getCadLivro();
		Hashtable<String, Usuario> cadUsuario = biblioteca.getCadUsuario();
		System.out.println("Insira um nome para o arquivo de cadastro de livros: ");
		String arqLiv = in.readLine();
		System.out.println("Insira um nome para o arquivo de cadastro de usuários: ");
		String arqUs = in.readLine();
		optionsMenu(arqLiv, cadLivro, arqUs, cadUsuario);
	}

	public static void carregaBiblioteca(String arqUs, String arqLiv) throws IOException, ClassNotFoundException, 
	       NenhumaCopiaEmprestadaEx, CopiaNaoDisponivelEx{

		biblioteca = new Biblioteca(arqUs, arqLiv);
		Hashtable<Integer,Livro> cadLivro = biblioteca.getCadLivro();
		Hashtable<String, Usuario> cadUsuario = biblioteca.getCadUsuario();
		optionsMenu(cadLivro, arqLiv, cadUsuario, arqUs);
	}
	
	public static void salvaBiblioteca(String arqLiv, String arqUs,
		       	Hashtable<Integer,Livro> cadLivro, Hashtable<String, Usuario> cadUsuario) throws IOException{

		Biblioteca.salvaArqUs(cadUsuario, arqUs);
		Biblioteca.salvaArqLiv(cadLivro, arqLiv);
	}

	public static void salvaBiblioteca(Hashtable<Integer,Livro> cadLivro, Hashtable<String,Usuario> cadUsuario) throws IOException{
	
		System.out.println("Insira o nome do arquivo de cadastro de Usuário: ");
		String arqUs = in.readLine();
		System.out.println("Insira o nome do arquivo de cadastro de Livros: ");
		String arqLiv = in.readLine();
		Biblioteca.salvaArqUs(cadUsuario, arqUs);
		Biblioteca.salvaArqLiv(cadLivro, arqLiv);
	}


	public static void optionsMenu(Hashtable<Integer, Livro> cadLivro, String arqLiv,
			Hashtable<String, Usuario> cadUsuario, String arqUs) throws IOException, NenhumaCopiaEmprestadaEx, CopiaNaoDisponivelEx{
	
		int resposta = 0;
		while(resposta < 1 || resposta > 4){ 
			System.out.println("Informe a operação que deseja realizar:" + 
					"\n[1] - Cadastro" + 
					"\n[2] - Empréstimo" +
					"\n[3] - Relatório" +
					"\n[4] - Salvar");
			resposta = Integer.parseInt(in.readLine());
			if (resposta < 1 || resposta > 3)
				System.out.println("Escolha uma opção de 1 a 4.");
		}
		switch(resposta){
			case 1:
				menuCadastro(cadUsuario, arqUs, cadLivro, arqLiv);
				break;
			case 2:
				menuEmprestimo(cadUsuario, arqUs, cadLivro, arqLiv);
				break;
			case 3:
				menuRelatorio(cadUsuario, arqUs, cadLivro, arqLiv);
				break;
			case 4:
				menuSalva(cadLivro, arqLiv, cadUsuario, arqUs);
				break;
			default:
				break;
		}
	}
	public static void optionsMenu(String arqLiv, Hashtable<Integer, Livro> cadLivro, 
			String arqUs, Hashtable<String, Usuario> cadUsuario) throws IOException{
			
		int resposta = 0;
		while(resposta < 1 || resposta > 4){
			System.out.println("\nInforme a operação que deseja realizar:" +
					"\n[1] - Cadastro" + 
					"\n[2] - Empréstimo (bloqueado)" + 
					"\n[3] - Relatório (bloqueado)" +
					"\n[4] - Salvar (bloqueado)");
			resposta = Integer.parseInt(in.readLine());
			if (resposta < 1 || resposta > 4)
				System.out.println("Escolha uma opção de 1 a 4");
		}
		switch(resposta){
			case 1:
				menuCadastro(cadUsuario, arqUs, cadLivro, arqLiv);
				break;
			case 2:
				System.out.println("Opção bloqueada, não há usuários e livros cadastrados no sistema.");
				optionsMenu(arqLiv, cadLivro, arqUs, cadUsuario);
				break;
			case 3:
				System.out.println("Opção bloqueada, não há usuários e livros cadastrados no sistema.");
				optionsMenu(arqLiv, cadLivro, arqUs, cadUsuario);
				break;
			case 4:
				System.out.println("Opção bloqueada, não há usuários e livros cadastrados no sistema.");
				optionsMenu(arqLiv, cadLivro, arqUs, cadUsuario);
				break;
			default:
				break;
		}
	}


	public static void menuSalva(Hashtable<Integer, Livro> cadLivro, String arqLiv,
			Hashtable<String, Usuario> cadUsuario, String arqUs) throws IOException{
			
		int resposta = 0;
		while(resposta != 1 && resposta != 2){
			System.out.println("[1] - Salvar arquivos com o mesmo nome." + 
					"\n[2] - Salvar arquivos com novos nomes.");
			resposta = Integer.parseInt(in.readLine());
			if (resposta != 1 && resposta != 2){
				System.out.println("Valor inválido.");
			}
		}
		if (resposta == 1){
			salvaBiblioteca(arqLiv, arqUs, cadLivro, cadUsuario);
		}
		if (resposta == 2){
			salvaBiblioteca(cadLivro, cadUsuario);
		}
	}
	
	public static void menuCadastro(Hashtable<String, Usuario> cadUsuario, String arqUs,
			Hashtable<Integer, Livro> cadLivro, String arqLiv) throws IOException{
			
		System.out.println("\nInforme a ação que deseja executar:" +
				"\n[1] - Cadastrar Usuários" +
				"\n[2] - Cadastrar Livros" +
				"\n[3] - Salvar");

		int resposta = Integer.parseInt(in.readLine());
		switch (resposta){
			case 1:
				cadastroDeUsuario(cadUsuario, arqUs, cadLivro, arqLiv);
				break;
			case 2: 
				cadastroDeLivros(cadUsuario, arqUs, cadLivro, arqLiv);
				break;
			case 3:
				menuSalva(cadLivro, arqLiv, cadUsuario, arqUs);
				break;
			default:
				break;
		}
	}

	public static void cadastroDeUsuario(Hashtable<String, Usuario> cadUsuario, String arqUs, 
			Hashtable<Integer, Livro> cadLivro, String arqLiv) throws IOException{
		
		String nome, sobrenome, CPF, adress, dia, mes, ano;

		System.out.println("Nome: ");
		nome = in.readLine();
		System.out.println("Sobrenome: ");
		sobrenome = in.readLine();
		System.out.println("Dia de nascimento: ");
		dia = in.readLine();
		System.out.println("Mês de nascimento: ");
		mes = in.readLine();
		System.out.println("Ano de nascimento: ");
		ano = in.readLine();
		System.out.println("CPF: ");
		CPF = in.readLine();
		System.out.println("Endereço: ");
		adress = in.readLine();

		Usuario usuario = new Usuario(nome, sobrenome, dia, mes, ano, CPF, adress);

		biblioteca.cadastraUsuario(cadUsuario, usuario.getCPF(), usuario);

		menuCadastro(cadUsuario, arqUs, cadLivro, arqLiv);
		
	}
	
	public static void cadastroDeLivros(Hashtable<String, Usuario> cadUsuario, String arqUs,
                        Hashtable<Integer, Livro> cadLivro, String arqLiv) throws IOException{
			
		int codLivro, qnt, numEmprest;
		String titLivro;

		System.out.println("Título: ");
		titLivro = in.readLine();
		System.out.println("Código: ");
		codLivro = Integer.parseInt(in.readLine());
		System.out.println("Quantidade Total: ");
		qnt = Integer.parseInt(in.readLine());
		System.out.println("Quantidade emprestada: ");
		numEmprest = Integer.parseInt(in.readLine());

		Livro livro  = new Livro(codLivro, titLivro, qnt, numEmprest);

		biblioteca.cadastraLivro(cadLivro, codLivro, livro);

		menuCadastro(cadUsuario, arqUs, cadLivro, arqLiv);

	}


	public static void menuEmprestimo(Hashtable<String, Usuario> cadUsuario, String arqUs,
			Hashtable<Integer, Livro> cadLivro, String arqLiv) throws IOException, NenhumaCopiaEmprestadaEx, CopiaNaoDisponivelEx{
	
		int resposta = 0;

		while(resposta < 1 || resposta > 3){
			System.out.println("\nInforme a ação que deseja executar:" +
                              "\n[1] - Acervo de livros" +
                              "\n[2] - Emprestar livro" +
                              "\n[3] - Devolver livro");
		
			resposta  = Integer.parseInt(in.readLine());
			if (resposta < 1 || resposta > 3)
				System.out.print("Valor inválido.");
		}
		switch(resposta){
			case 1:
				System.out.println(biblioteca.imprimeLivros());
				menuEmprestimo(cadUsuario, arqUs, cadLivro, arqLiv);
				break;
			case 2:
				emprestimoDeLivro(cadUsuario, arqUs, cadLivro, arqLiv);
				break;
			case 3:
				devolucaoDeLivro(cadUsuario, arqUs, cadLivro, arqLiv);
				break;
			default:
				break;
		}
	}

	public static void emprestimoDeLivro(Hashtable<String, Usuario> cadUsuario, String arqUs, 
			Hashtable<Integer, Livro> cadLivro, String arqLiv) throws CopiaNaoDisponivelEx, IOException, NenhumaCopiaEmprestadaEx{
		try{
			System.out.println("Insira o CPF do usuário: ");
			String CPF = in.readLine();
			System.out.println("Insira o código do livro: ");
			int cod = Integer.parseInt(in.readLine());
			
			Usuario user = biblioteca.getUsuario(CPF); 
			Livro livro = biblioteca.getLivro(cod);

			biblioteca.emprestaLivro(user, livro);
			
			System.out.println(livro.toString());
			System.out.println(user.toString());
		}
		catch(CopiaNaoDisponivelEx e){
			int resposta = 0;
			while(resposta != 1 && resposta != 2){
				System.out.println(e.getMessage() + 
						"\nGostaria de pegar outro livro?" +
						"\n[1] - Sim" + 
						"\n[2] - Não");

				resposta = Integer.parseInt(in.readLine());
				if (resposta != 1 && resposta != 2)
					System.out.println("\nValor inválido.\n");
			}
			if (resposta == 1)
				emprestimoDeLivro(cadUsuario, arqUs, cadLivro, arqLiv);
			else
				optionsMenu(cadLivro, arqLiv, cadUsuario, arqUs);
		}
	}

	public static void devolucaoDeLivro(Hashtable<String, Usuario> cadUsuario, String arqUs, 
			Hashtable<Integer, Livro> cadLivro, String arqLiv) throws NenhumaCopiaEmprestadaEx, IOException, CopiaNaoDisponivelEx{

		 try{
                        System.out.println("Insira o CPF do usuário: ");
                        String CPF = in.readLine();
                        System.out.println("Insira o código do livro: ");
                        int cod = Integer.parseInt(in.readLine());

                        Usuario user = biblioteca.getUsuario(CPF);
                        Livro livro = biblioteca.getLivro(cod);

                        biblioteca.devolveLivro(user, livro);

                        System.out.println(livro.toString());
                        System.out.println(user.toString());
                }
		catch(NenhumaCopiaEmprestadaEx e){
			int resposta = 0;
			while (resposta != 1 && resposta != 2){
				System.out.println(e.getMessage() + 
						"\nGostaria de devolver outro livro?" +
						"\n[1] - Sim" +
						"\n[2] - Não");
				resposta = Integer.parseInt(in.readLine());
				if (resposta != 1 && resposta != 2)
					System.out.println("\nValor inválido. \n");
			}
			if (resposta == 1)
				devolucaoDeLivro(cadUsuario, arqUs, cadLivro, arqLiv);
			else
				optionsMenu(cadLivro, arqLiv, cadUsuario, arqUs);
		}
	}

	public static void menuRelatorio(Hashtable<String, Usuario> cadUsuario, String arqUs, 
			Hashtable<Integer, Livro> cadLivro, String arqLiv) throws IOException, NenhumaCopiaEmprestadaEx, CopiaNaoDisponivelEx{
		
		int resposta = 0;
		while(resposta < 1 || resposta > 5){
			System.out.println("Informe a ação que deseja executar:" +
                                                "\n[1] - Listar acervo de livros" +
                                                "\n[2] - Exibir cadastro de usuários" +
						"\n[3] - Exibir detalhes de um usuário" +
						"\n[4] - Exibir detalhes de um livro" +
						"\n[5] - Sair");

			resposta = Integer.parseInt(in.readLine());

			if (resposta <1 || resposta > 5)
				System.out.println("Opção inválida.");
		}
		switch (resposta){
			case 1:
				listarLivros(cadUsuario, arqUs, cadLivro, arqLiv);
				break;
			case 2:
				listarUsuario(cadUsuario, arqUs, cadLivro, arqLiv);
				break;
			case 3:
				dadosUsuario(cadUsuario, arqUs, cadLivro, arqLiv);
				break;
			case 4: 
				dadosUsuario(cadUsuario, arqUs, cadLivro, arqLiv);
				break;
			case 5:
				optionsMenu(cadLivro, arqLiv, cadUsuario, arqUs);
				break;
			default:
				break;
		}		
	}

	public static void listarLivros(Hashtable<String, Usuario> cadUsuario, String arqUs, 
			Hashtable<Integer, Livro> cadLivro, String arqLiv) throws IOException, NenhumaCopiaEmprestadaEx, CopiaNaoDisponivelEx{
		
		System.out.println(biblioteca.imprimeLivros());

		int resposta = 0;

		while(resposta !=1 && resposta != 2){
			System.out.println("Deseja mais algum relatório?" +
					"\n[1] - Sim" +
					"\n[2] - Não");
			
			resposta = Integer.parseInt(in.readLine());
			if (resposta != 1 && resposta != 2)
				System.out.println("Opção inválida.");
		}

		if (resposta == 1)
			menuRelatorio(cadUsuario, arqUs, cadLivro, arqLiv);
		else
			optionsMenu(cadLivro, arqLiv, cadUsuario, arqUs);
	}

	public static void listarUsuario(Hashtable<String, Usuario> cadUsuario, String arqUs,
                        Hashtable<Integer, Livro> cadLivro, String arqLiv) throws IOException, NenhumaCopiaEmprestadaEx, CopiaNaoDisponivelEx{

		System.out.println(biblioteca.imprimeUsuarios());

		int resposta = 0;

                while(resposta !=1 && resposta != 2){
                        System.out.println("Deseja mais algum relatório?" +
                                        "\n[1] - Sim" +
                                        "\n[2] - Não");

                        resposta = Integer.parseInt(in.readLine());
                        if (resposta != 1 && resposta != 2)
                                System.out.println("Opção inválida.");
                }

                if (resposta == 1)
                        menuRelatorio(cadUsuario, arqUs, cadLivro, arqLiv);
                else
                        optionsMenu(cadLivro, arqLiv, cadUsuario, arqUs);
        }

	public static void dadosUsuario(Hashtable<String, Usuario> cadUsuario, String arqUs,
                        Hashtable<Integer, Livro> cadLivro, String arqLiv) throws IOException, NenhumaCopiaEmprestadaEx, CopiaNaoDisponivelEx{

		System.out.println("Insira o CPF do usuário que deseja consultar: ");
		String CPF = in.readLine();

		Usuario user = biblioteca.getUsuario(CPF);
		System.out.println(user.toString());

		int resposta = 0;

                while(resposta !=1 && resposta != 2){
                        System.out.println("Deseja mais algum relatório?" +
                                        "\n[1] - Sim" +
                                        "\n[2] - Não");

                        resposta = Integer.parseInt(in.readLine());
                        if (resposta != 1 && resposta != 2)
                                System.out.println("Opção inválida.");
                }

                if (resposta == 1)
                        menuRelatorio(cadUsuario, arqUs, cadLivro, arqLiv);
                else
                        optionsMenu(cadLivro, arqLiv, cadUsuario, arqUs);
        }

	public static void dadosLivro(Hashtable<String, Usuario> cadUsuario, String arqUs,
                        Hashtable<Integer, Livro> cadLivro, String arqLiv) throws IOException, NenhumaCopiaEmprestadaEx, CopiaNaoDisponivelEx{

		System.out.println("Insira o código do livro que deseja consultar: ");
		int codigo = Integer.parseInt(in.readLine());

		Livro livro = biblioteca.getLivro(codigo);
		System.out.println(livro.toString());

		int resposta = 0;

                while(resposta !=1 && resposta != 2){
                        System.out.println("Deseja mais algum relatório?" +
                                        "\n[1] - Sim" +
                                        "\n[2] - Não");

                        resposta = Integer.parseInt(in.readLine());
                        if (resposta != 1 && resposta != 2)
                                System.out.println("Opção inválida.");
                }

                if (resposta == 1)
                        menuRelatorio(cadUsuario, arqUs, cadLivro, arqLiv);
                else
                        optionsMenu(cadLivro, arqLiv,  cadUsuario, arqUs);
        }


}
