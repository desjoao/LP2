import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P2nX{
	public static void main(String[] args) throws IOException{
		MinhaListaOrdenavel listaOrd = new MinhaListaOrdenavel();
		//Criação de 10 objetos das classes Homem e Mulher
		Homem homem1 = new Homem("João", "Guedes", "17", "dezembro", "1996", "10466842996", 78F, 1.79F);
		Homem homem2 = new Homem("Anibal", "Guedes", "22", "junho", "1961", "83397954738", 82F, 1.76F);
		Homem homem3 = new Homem("Mario", "Guedes", "08", "junho", "1993", "86392516140", 85F, 1.90F);
		Homem homem4 = new Homem("Alvaro", "Guedes", "31", "julho", "2022", "83518461800", 13F, 0.9F);
		Homem homem5 = new Homem("Victor", "Guedes", "27", "junho", "1994", "15438248702", 82F, 1.75F);
		Mulher mulher1 = new Mulher("Lízia", "Fiaux", 22, 07, 1998, "16212327785", 60F, 1.64F);
		Mulher mulher2 = new Mulher("Marcia", "Matheos", 28, 06, 1971, "25429711616", 80F, 1.70F);
		Mulher mulher3 = new Mulher("Maria", "Guedes", 17, 06, 1994, "05222322483", 74F, 1.75F);
		Mulher mulher4 = new Mulher("Aurora", "Guedes", 30, 04, 2021, "66718641600", 16F, 1F);
		Mulher mulher5 = new Mulher("Gianna", "Guedes", 28, 02, 2024, "50825315301", 8F, 0.6F);

		//Adicição dos 10 objetos a uma ArrayList que armazena objetos da classe PessoaIMC
		listaOrd.add(homem1); listaOrd.add(homem2); listaOrd.add(homem3); listaOrd.add(homem4); listaOrd.add(homem5);
		listaOrd.add(mulher1); listaOrd.add(mulher2); listaOrd.add(mulher3); listaOrd.add(mulher4); listaOrd.add(mulher5);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		System.out.println("[1] - Imprimir Objetos da lista." + 
				"\n[2] - Sair \nEscolha uma opção:");
		try{
			int entrada = Integer.parseInt(in.readLine());
			if (entrada == 1){
				do{
					System.out.println("---------------------"+
						"\n[1] - Peso (menor - maior)"+ 
						"\n[2] - Peso (maior - menor)"+
						"\n[3] - Altura (menor - maior)"+
						"\n[4] - Altura (maior - menor)"+
						"\n[5] - Idade (menor - maior)"+
						"\n[6] - Idade (maior - menor)"+
						"\n[7] - Nome (menor - maior)"+
						"\n[8] - Nome (maior - menor)"+
						"\n[9] -  CPF (menor - maior)"+
						"\n[10] - CPF (maior - menor)"+
						"\n[11] - IMC (menor - maior)"+
						"\n[12] - IMC (maior - menor)"+
						"\n[13] - Data de Aniversario (menor - maior)"+
						"\n[14] - Data de Aniversario (maior - menor)"+
						"\n[15] - Genero (Feminino - Masculino)"+	
						"\n[16] - Genero (Masculino - Feminino)" + 
						"\nEscolha uma opção:");
					entrada = Integer.parseInt(in.readLine());
					listaOrd.ordena(entrada);
				} while(entrada <= 0 || entrada >=17);
				for (int i = 0; i < listaOrd.getSize(); i++){
				System.out.println(listaOrd.get(i).toString() +
						"\n---------------------");
				}
				System.out.println("FIM.");
			}
		} catch(NumberFormatException e){
			System.out.println("Formato de entrada inválido, use apenas valores numéricos.");
		}
		catch(IOException e){
			System.out.println("Formato de entrada inválido.");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
