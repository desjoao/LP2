package lp2g23.biblioteca;

public class ValidaData{
	
	// Métodos validadores para dia, mês e ano.
	public static boolean isDia(int dia){
		if (dia >=1 && dia <= 31)
			return true;
		System.out.println("Valores válidos para dia: [1 - 31].");
		return false;	
	}
	public static boolean isDia(String dia){
		if (!dia.matches("^[0-9]*$")){
			System.out.println("Insira apenas valores numéricos para o dia.");
			return false;
		}
		int d = Integer.parseInt(dia);
		if (d >=1 && d <= 31)
			return true;
		System.out.println("Valores válidos para dia: [1 - 31].");
		return false;
	}
	public static boolean isMes(int mes){
		if (mes >=1 && mes <=12)
			return true;
		System.out.println("Valores válidos para mês: [1 - 12].");
		return false;
	}	
	public static boolean isMes(String mes){
		for (Mes m: Mes.values()){
			if (m.toString().equals(mes.toUpperCase()))
					return true;
			else if(Integer.parseInt(mes) == m.getMesNumero())
				return true;
		}
		if (!mes.matches("^[0-9]*$") && !mes.matches("^[a-zA-Z]*$")){
			System.out.println("Apenas valores numéricos ou o nome do mês.");
			return false;
		}	
		System.out.println("Valores válidos para mês: [1-12] ou [janeiro - dezembro].");
		return false;
	}

	public static boolean isAno(int ano){
		if (ano >= 1904 && ano <= 2024)
			return true;
		System.out.println("Valores válidos para ano: [1904 - 2024].");
		return false;
	}
	public static boolean isAno(String ano){
		if (!ano.matches("^[0-9]*$")){
			System.out.println("Insira apenas valores numéricos para o ano.");
			return false;
		}
		int a = Integer.parseInt(ano);
		if (a >= 1904 && a <= 2024)
			return true;
		System.out.println("Valores válidos para ano: [1904 - 2024].");
		return false;
	}
	
	// Método validador para data
	public static boolean isDataValida(int dia, int mes, int ano){
		if (isAno(ano) == true && isMes(mes) == true && isDia(dia) == true){
			switch (mes){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					return true;
				case 4:
				case 6:
				case 9:
				case 11:
					if (dia <=30)
						return true;
					System.out.println("Máximo permitido = 30");
					return false;
				case 2:
					if ((ano%4==0 && ano%100!=0 || ano%400 ==0) && dia <= 29)	
						return true;
					else if (ano%4==0 && ano%100!=0 || ano%400 == 0){
						System.out.println("Máximo de dias permitido = 29");
						return false;}
					else if (dia >= 29){
						System.out.println("Máximo de dias permitido = 28");
						return false;}
					else if(dia<=28)
						return true;
					return false;
				default:
					return false;

			}
		}
		return false;
	}
	public static boolean isDataValida(String dia, String mes, String ano){
		if (mes.matches("[0-9]+")){
			if (isAno(ano) == true && isMes(mes) == true && isDia(dia) == true){
				switch(Integer.parseInt(mes)){
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						return true;
					case 4:
					case 6:
					case 9:
					case 11:
						if (Integer.parseInt(dia) <= 30)
							return true;
						return false;
					case 2:
						if((Integer.parseInt(ano)%4==0 && Integer.parseInt(ano)%100 != 0 ||
								       	Integer.parseInt(ano)%400==0) && Integer.parseInt(dia) == 29)
							return true;
						else if (Integer.parseInt(dia) > 29){
							System.out.println("Para o ano informado, feveiro possui no máximo 29 dias.");
							return false;
						}
						else if (Integer.parseInt(dia) == 29){
							System.out.println("Para o ano informado, fevereiro possui no máximo 28 dias.");
							return false;
						}
						else if (Integer.parseInt(dia) <= 28)
							return true;
						return false;
					default:
						return false;
				}
			}
			return false;
		}
		else if (mes.matches("^[a-zA-Z]+$")){
			int n = 0;
			for (Mes m: Mes.values()){
				if (mes.toUpperCase().equals(m.toString())){
					n = m.getMesNumero();
					break;
				}
			}
			if (isAno(ano) == true && isMes(n) == true && isDia(dia) == true){
				switch(mes.toUpperCase()){
					case "JANEIRO":
					case "MARCO":
					case "MAIO":
					case "JULHO":
					case "AGOSTO":
					case "OUTUBRO":
					case "DEZEMBRO":
						return true;
					case "ABRIL":
					case "JUNHO":
					case "SETEMBRO":
					case "NOVEMBRO":
						if(Integer.parseInt(dia)<= 30)
							return true;
						return false;
					case "FEVEREIRO":
						if ((Integer.parseInt(ano)%4==0 && Integer.parseInt(ano)%100 != 0 ||
								       	Integer.parseInt(ano)%400==0) && Integer.parseInt(dia) <= 29)
							return true;
						else if (Integer.parseInt(dia) <= 28)
							return true;
						return false;
					default:
						return false;
				}
			}
			return false;
		}


	return false;	
	}



}

