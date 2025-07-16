package lp2g23.biblioteca;
import java.util.GregorianCalendar;

public class EmprestPara{

	// Atributos da classe.
	private GregorianCalendar dataEmprest, dataDevol;
	private String CPF;

	// Construtores da classe EmprestPara, um com a data de devolução estabelecida, outro sem.
	public EmprestPara(GregorianCalendar dataEmprest, GregorianCalendar dataDevol, String CPF){
		if (ValidaCPF.isCPF(CPF)){
			this.dataEmprest = dataEmprest;
			this.dataDevol = dataDevol;
			this.CPF = CPF;
		}
	}
	public EmprestPara(GregorianCalendar dataEmprest, String CPF){
		if (ValidaCPF.isCPF(CPF)){
			this.dataEmprest = dataEmprest;
			this.dataDevol = null;
			this.CPF = CPF;
		}
	}

	// Método para atribuir a data de empréstimo.
	public void setDataEmprest(GregorianCalendar data){
		this.dataEmprest = data;
	}

	// Método para retornar a data de empréstimo.
	public GregorianCalendar getDataEmprest(){
		return dataEmprest;
	}

	// Método para atribuir a data de devolução.
	public void setDataDevol(GregorianCalendar data){
		this.dataDevol = data;
	}

	// Método para retornar a data de devolução.
	public GregorianCalendar getDataDevol(){
		return dataDevol;
	}

	// Método para atribuir o CPF do usuário.
	public void setCPF(String CPF){
		if(ValidaCPF.isCPF(CPF))
			this.CPF = CPF;
	}
	// Método para retornar o CPF do usuário.
	public String getCPF(){
		return this.CPF;
	}

	// Método toString da classe EmprestPara.
	public String toString(){
		return "CPF do usário: " + getCPF() +
			"\nData de empréstimo: " + getDataEmprest() +
			"\nData de devolução: " + getDataDevol();
	}

}


