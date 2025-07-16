public class TesteCPF{
	public static void main(String[] args){
		String cpf = "09316860679";
		String cpf2 = "64839710791";
		String cpf3 = "021.200.087-01";
		String cpf4 = "093.168.626/12";
		System.out.println(ValidaCPF.isCPF(cpf));
	        System.out.println(ValidaCPF.isCPF(cpf2));
		System.out.println(ValidaCPF.isCPF(cpf3));
	        System.out.println(ValidaCPF.isCPF(cpf4));
		//System.out.println(ValidaCPF.imprimeCPF(cpf));
		//System.out.println(ValidaCPF.toLong(cpf));

	}
}
