import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.lang.Math;
import java.util.GregorianCalendar;

public class MinhaListaOrdenavel {
	//ArrayList para armazenar objetos classe PessoaIMC ou de suas subclasses
	public ArrayList<PessoaIMC> listaOrd = new ArrayList<PessoaIMC>();
	
	//Método para adicionar objetos na ArrayList
	public void add(PessoaIMC p){
		listaOrd.add(p);
	}

	//Método para pegar um objetos da ArrayList
	public PessoaIMC get(int i){
		return listaOrd.get(i);
	}

	//Método para retornar o tamanho da ArrayList
	public int getSize(){
		return listaOrd.size();
	}

	// MÉTODOS DE COMPARAÇÃO
	//Comparadores de peso.
	public Comparator<PessoaIMC> peso_crescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			float pf1, pf2;
			pf1 = p1.getPeso();
			pf2 = p2.getPeso();
			return Math.round(pf1-pf2);
		}
	};
	public Comparator<PessoaIMC> peso_decrescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			float pf1, pf2;
			pf1 = p1.getPeso();
			pf2 = p2.getPeso();
			return (-1)*Math.round(pf1-pf2);
		}
	};

	//Comparadores de altura.
	public Comparator<PessoaIMC> altura_crescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			String pf1, pf2;
			pf1 = Float.toString(p1.getAltura());
			pf2 = Float.toString(p2.getAltura());
			return pf1.compareTo(pf2);
		}
	};
	public Comparator<PessoaIMC> altura_decrescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			String pf1, pf2;
			pf1 = Float.toString(p1.getAltura());
			pf2 = Float.toString(p2.getAltura());
			return (-1)*pf1.compareTo(pf2);
		}
	};

	//Comparadores de idade.
	public Comparator<PessoaIMC> idade_crescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			GregorianCalendar pf1, pf2;
			pf1 = p1.getAniversario();
			pf2 = p2.getAniversario();
			return pf2.compareTo(pf1);
		}
	};
	public Comparator<PessoaIMC> idade_decrescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			GregorianCalendar pf1, pf2;
			pf1 = p1.getAniversario();
			pf2 = p2.getAniversario();
			return (-1)*pf2.compareTo(pf1);
		}
	};

	//Comparadores de nome.
	public Comparator<PessoaIMC> nome_crescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			String pf1, pf2;
			pf1 = p1.getNome();
			pf2 = p2.getNome();
			return pf1.compareTo(pf2);
		}
	};
	public Comparator<PessoaIMC> nome_decrescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			String pf1, pf2;
			pf1 = p1.getNome();
			pf2 = p2.getNome();
			return (-1)*pf1.compareTo(pf2);
		}
	};

	//Comparadores de IMC.
	public Comparator<PessoaIMC> imc_crescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			float pf1, pf2;
			pf1 = p1.calculaIMC();
			pf2 = p2.calculaIMC();
			return Math.round(pf1 - pf2);
		}
	};
	public Comparator<PessoaIMC> imc_decrescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			float pf1, pf2;
			pf1 = p1.calculaIMC();
			pf2 = p2.calculaIMC();
			return (-1)*Math.round(pf1 - pf2);
		}
	};

	//Comparadores de CPF.
	public Comparator<PessoaIMC> cpf_crescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			String  pf1, pf2;
			pf1 = p1.getCPF();
			pf2 = p2.getCPF();
			return pf1.compareTo(pf2);
		}
	};
	public Comparator<PessoaIMC> cpf_decrescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			String pf1, pf2;
			pf1 = p1.getCPF();
			pf2 = p2.getCPF();
			return (-1)*pf1.compareTo(pf2);
		}
	};

	//Comparador de Gênero
	public Comparator<PessoaIMC> genero_crescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			if (p1 instanceof Homem && p2 instanceof Homem)
				return 0;
			if (p1 instanceof Homem && p2 instanceof Mulher)
				return 1;
			if(p1 instanceof Mulher && p2 instanceof Homem)
				return -1;
			else
				return 0;
		}
	};
	public Comparator<PessoaIMC> genero_decrescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			if (p1 instanceof Homem && p2 instanceof Homem)
				return 0;
			if (p1 instanceof Homem && p2 instanceof Mulher)
				return -1;
			if(p1 instanceof Mulher && p2 instanceof Homem)
				return 1;
			else
				return 0;
		}
	};

	//Comparador de data de nascimento.
	public Comparator<PessoaIMC> data_crescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			GregorianCalendar pf1, pf2;
			pf1 = p1.getAniversario();
			pf2 = p2.getAniversario();
			return pf2.compareTo(pf1);
		}
	};
	public Comparator<PessoaIMC> data_decrescenteC = new Comparator<PessoaIMC>(){
		@Override
		public int compare(PessoaIMC p1, PessoaIMC p2){
			GregorianCalendar pf1, pf2;
			pf1 = p1.getAniversario();
			pf2 = p2.getAniversario();
			return (-1)*pf2.compareTo(pf1);
		}
	};


	/*Tabela de contantes utilizadas como entrada no método de ordenar.
	  Criada para deixar mais compreensível os critérios na operação "Switch/Case" */
	public enum CriteriosOrdenacao{
		PESO(1),
		PESO_REVERSO(2),
		ALTURA(3),
		ALTURA_REVERSO(4),
		IDADE(5),
		IDADE_REVERSO(6),
		NOME(7),
		NOME_REVERSO(8),
		CPF(9),
		CPF_REVERSO(10),
		IMC(11),
		IMC_REVERSO(12),
		DATA(13),
		DATA_REVERSO(14),
		GENERO(15),
		GENERO_REVERSO(16);

		private final int criterioNumero;

		CriteriosOrdenacao(int n){
                	this.criterioNumero = n;
        	}
		public int getCriterioNumero(){
                	return criterioNumero;
        	}
	}
	
	//Método de ordenação da ArrayList, fazendo a ordenação de acordo com o critério escolhido.
	public ArrayList<PessoaIMC> ordena(int criterio){
		String nome = new String();
		for (CriteriosOrdenacao c: CriteriosOrdenacao.values()){
			if(criterio == c.getCriterioNumero()){
				nome = c.toString();
				break;
			}
			nome = "----------------------"+
				"\nCritério inválido, escolha um critéiro correspondente ao intervalo de 1 a 16.";
		}
		switch (nome){
			case "PESO": 
				Collections.sort(this.listaOrd, peso_crescenteC);
				break;
			case "PESO_REVERSO":
				Collections.sort(this.listaOrd, peso_decrescenteC);
				break;
			case "ALTURA":
				Collections.sort(this.listaOrd, altura_crescenteC);
				break;
			case "ALTURA_REVERSO":
				Collections.sort(this.listaOrd, altura_decrescenteC);
				break;
			case "IDADE":
				Collections.sort(this.listaOrd, idade_crescenteC);
				break;
			case "IDADE_REVERSO":
				Collections.sort(this.listaOrd, idade_decrescenteC);
				break;
			case "NOME":
				Collections.sort(this.listaOrd, nome_crescenteC);
				break;
			case "NOME_REVERSO":
				Collections.sort(this.listaOrd, nome_decrescenteC);
				break;
			case "CPF":
				Collections.sort(this.listaOrd, cpf_crescenteC);
				break;
			case "CPF_REVERSO":
				Collections.sort(this.listaOrd, cpf_decrescenteC);
				break;
			case "IMC":
				Collections.sort(this.listaOrd, imc_crescenteC);
				break;
			case "IMC_REVERSO":
				Collections.sort(this.listaOrd, imc_decrescenteC);
				break;
			case "DATA":
				Collections.sort(this.listaOrd, data_crescenteC);
				break;
			case "DATA_REVERSO":
				Collections.sort(this.listaOrd, data_decrescenteC);
				break;
			case "GENERO":
				Collections.sort(this.listaOrd, genero_crescenteC);
				break;
			case "GENERO_REVERSO":
				Collections.sort(this.listaOrd, genero_decrescenteC);
				break;
			default:
				System.out.println(nome);
		}
		return this.listaOrd;
	}

}
