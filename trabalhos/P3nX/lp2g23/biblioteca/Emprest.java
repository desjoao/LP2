package lp2g23.biblioteca;
import java.util.GregorianCalendar;

public class Emprest{

	// Atributos da classe.
	private GregorianCalendar dataEmprest, dataDevol = null;
	private int codLivro;
	
	// Métodos para atribuir a data de empréstimo, uso de diferentes assinaturas.
	public void setDataEmprest(int dia, int mes, int ano){
		if (ValidaData.isDataValida(dia, mes, ano)){
			this.dataEmprest = new GregorianCalendar(ano, mes-1, dia);
		}	
		else{
			this.dataEmprest = new GregorianCalendar();
		}
	}
	public void setDataEmprest(String dia, String mes, String ano){
                if(ValidaData.isDataValida(dia, mes, ano)){
                        int d = Integer.parseInt(dia);
                        int a = Integer.parseInt(ano);
                        int m;
                        if (mes.matches("^[a-zA-Z]+$")){
                                for(Mes month: Mes.values()){
                                        if (mes.toUpperCase().equals(month.toString())){
                                                m = month.getMesNumero() - 1;
                                                this.dataEmprest = new GregorianCalendar(a, m, d);
                                                break;
                                        }
                                }
                        }
                        else{
                                m = Integer.parseInt(mes);
                                this.dataEmprest = new GregorianCalendar(a, m -1, d);
                        }
                }
                else{
                        this.dataEmprest = new GregorianCalendar();
                }
        }
	public void setDataEmprest(GregorianCalendar data){
		this.dataEmprest = data;
	}

	// Método para retornar a data de empréstimo.
	public GregorianCalendar getDataEmprest(){
		return dataEmprest;
	}
	
	// Método para atribuir a data de devolução, uso de uma única assinatura.
	public void setDataDevol(GregorianCalendar data){
		this.dataDevol = data;
	}

	//Método para retornar a data de devolução.
	public GregorianCalendar getDataDevol(){
		return dataDevol;
	}

	// Método para atribuir o código do livro.
	public void setCodLivro(int codLivro){
		this.codLivro = codLivro;
	}

	// Método para retornar o código do livro.
	public int getCodLivro(){
		return codLivro;
	}

	// Construtores da classe Emprest.
	public Emprest(int dia, int mes, int ano, int codLivro){
		setDataEmprest(dia, mes, ano);
		setCodLivro(codLivro);
	}

	public Emprest(String dia, String mes, String ano, int codLivro){
		setDataEmprest(dia, mes, ano);
		setCodLivro(codLivro);
	}

	public Emprest(GregorianCalendar data, int codLivro){
		setDataEmprest(data);
		setCodLivro(codLivro);
	}

	// Método toString da classe Emprest.
	public String toString(){
		if (dataDevol != null){
			return "Código do Livro: " + getCodLivro() +
				"\nData de Empréstimo: " + getDataEmprest().get(GregorianCalendar.DAY_OF_MONTH) +
				"/" + getDataEmprest().get(GregorianCalendar.MONTH) +
				"/" + getDataEmprest().get(GregorianCalendar.YEAR) +
				"\nData de Devolução: " + getDataDevol().get(GregorianCalendar.DAY_OF_MONTH) +
				"/" + getDataDevol().get(GregorianCalendar.MONTH) + 
				"/" + getDataDevol().get(GregorianCalendar.YEAR);
		}
		else{
			return "Código do Livro: " + getCodLivro() +
                                "\nData de Empréstimo: " + getDataEmprest().get(GregorianCalendar.DAY_OF_MONTH) +
                                "/" + getDataEmprest().get(GregorianCalendar.MONTH) +
                                "/" + getDataEmprest().get(GregorianCalendar.YEAR) +
                                "\nData de Devolução: PENDENTE.";
		}
	}
}

