import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.NumberFormatException;
import java.io.IOException;

public class P1nX{
	public static void main(String[] args) throws IOException {
		String nome, sobreNome, CPF, genero;
		String dia, mes, ano;
		String peso, altura;

		if (args.length == 0)
			System.out.println("O programa deve ser inicializado com a seguinte sintaxe: \n"
			+ "-----------------------------------------------------------------------------\n" + 
			"java P1nX <genero> <nome> <sobrenome> <dia> <mes> <ano> <CPF> <peso> <altura>\n" +
			"-----------------------------------------------------------------------------\n");		
		else if (ValidaGenero.isMulher(args[0])){
			Mulher pessoa_0 = new Mulher(args [0], args[1], args[2], Integer.parseInt(args[3]),
					Integer.parseInt(args[4]), Integer.parseInt(args[5]), args[6], Float.parseFloat(args[7]), Float.parseFloat(args[8]));
			System.out.println(pessoa_0.toString());
		}
		else if (ValidaGenero.isHomem(args[0])){
			Homem pessoa_0 = new Homem(args[0], args[1] , args[2], Integer.parseInt(args[3]), Integer.parseInt(args[4]),
					Integer.parseInt(args[5]), args[6], Float.parseFloat(args[7]), Float.parseFloat(args[8]));
			System.out.println(pessoa_0.toString());
		}
		else{
			System.out.println("ERRO: insira corretamente a sintaxe:"
					+ "\njava P1nX <genero> <nome> <sobrenome> <dia> "
					+ "<mes> <ano> <CPF> <peso> <altura>");
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Quantas pessoas a mais deseja inserir? ");
		String qnt = in.readLine();
		while(!qnt.matches("^[0-9]+")){
			System.out.println("Insira um número natural");
			qnt = in.readLine();
		}
		
		try{
			int tamanhoVetor = Integer.parseInt(qnt);
			Pessoa[] pessoas = new Pessoa[tamanhoVetor];
			repetição:
			for (int i = 0; i < pessoas.length; i++){
				System.out.println("----------");
				System.out.printf("Pessoa %d", i+1);
				System.out.print("\nGênero: ");
				genero = in.readLine();
				if (QuebraLoop.isEmpty(genero))
					break;
				while(!ValidaGenero.isGenero(genero)){
					System.out.print("Genero: ");
					genero = in.readLine();
					if(QuebraLoop.isEmpty(genero))
						break repetição;
				}
				System.out.print("Nome: ");
				nome = in.readLine();
				if(QuebraLoop.isEmpty(nome))
					break;
				while(!ValidaNome.isNome(nome)){
					System.out.print("Nome: ");
					nome = in.readLine();
					if(QuebraLoop.isEmpty(nome))
						break repetição;
				}
				System.out.print("Sobrenome: ");
				sobreNome = in.readLine();
				if(QuebraLoop.isEmpty(sobreNome))
					break;
				while(!ValidaNome.isNome(sobreNome)){
					System.out.print("Sobrenome: ");
					sobreNome = in.readLine();
					if(QuebraLoop.isEmpty(sobreNome))
						break repetição;
				}
				System.out.print("Dia de nascimento: ");
				dia = in.readLine();
				if (QuebraLoop.isEmpty(dia))
					break;
				System.out.print("Mês de Nascimento: ");
				mes = in.readLine();
				if (QuebraLoop.isEmpty(mes))
					break;
				System.out.print("Ano de Nascimento: ");
				ano = in.readLine();
				if (QuebraLoop.isEmpty(ano))
					break;
				while(!ValidaData.isDataValida(dia, mes, ano)){
					System.out.print("Dia de nascimento: ");
					dia = in.readLine();
					if(QuebraLoop.isEmpty(dia))
						break repetição;
					System.out.print("Mês de Nascimento: ");
					mes = in.readLine();
					if(QuebraLoop.isEmpty(mes))
						break repetição;
					System.out.print("Ano de nascimento: ");
					ano = in.readLine();
					if(QuebraLoop.isEmpty(ano))
						break repetição;
				}
				System.out.print("CPF: ");
				CPF = in.readLine();
				if (QuebraLoop.isEmpty(CPF))
					break;
				while(!ValidaCPF.isCPF(CPF)){
					System.out.print("CPF: ");
					CPF = in.readLine();
					if (QuebraLoop.isEmpty(CPF))
						break repetição;
				}
				System.out.print("Peso: ");
				peso = in.readLine();
				if (QuebraLoop.isEmpty(peso))
					break;
				while(!ValidaPeso.isPeso(peso)){
					System.out.print("Peso: ");
					peso = in.readLine();
					if (QuebraLoop.isEmpty(peso))
						break repetição;
				}
				System.out.print("Altura: ");
				altura = in.readLine();
				if (QuebraLoop.isEmpty(altura))
					break;
				while(!ValidaAltura.isAltura(altura)){
					System.out.print("Altura: ");
					altura = in.readLine();
					if (QuebraLoop.isEmpty(altura))
						break repetição;
				}
				if (genero.toUpperCase().equals("M") || genero.toUpperCase().equals("MASCULINO")){
					pessoas[i] = new Homem(genero, nome, sobreNome, dia, mes, ano, CPF, Float.parseFloat(peso), Float.parseFloat(altura));
				}
				else{
					pessoas[i] = new Mulher(genero, nome, sobreNome, dia, mes, ano, CPF, Float.parseFloat(peso), Float.parseFloat(altura));
				}
			}
			int c = 0;
			if(Pessoa.numPessoas() > 0 ){
				for (int j = 0; j < pessoas.length; j++){
					System.out.println(pessoas[j].toString());
					if (pessoas[j] instanceof Homem)
						c++;
					}
			}
			if(args.length == 0){
				System.out.printf("\nNúmero de homens: %d \nNúmero de mulheres: %d \n\nPrograma encerrado.\n", c, c);
			}
			
			else if(ValidaGenero.isMulher(args[0])){
				System.out.printf("\nNúmero de homens: %d \nNúmero de mulheres: %d \n\nPrograma encerrado.\n", c, pessoas.length-c+1);
			}
			else if(ValidaGenero.isHomem(args[0])){
				System.out.printf("\nNúmero de homens: %d \nNúmero de mulheres: %d \n\nPrograma encerrado.\n", c+1, pessoas.length-c);
			}

		}
		catch(NumberFormatException e){
			System.out.println("Insira um valor numérico.\nErro: " + e.getMessage());
		}

		catch(IOException e){
			System.out.println(e.getMessage());
		}







	}
}
