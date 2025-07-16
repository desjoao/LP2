import java.lang.Math;
import java.util.InputMismatchException;

public class ValidaCPF {

    public static boolean isCPF(String cpf){
        // considera-se erro CPF"s formados por uma sequencia de numeros iguais
	//String CPF = cpf.replaceAll("[\\.\\-/]", "");
        if (cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999") ||
            cpf.length() != 14 && cpf.length() != 11 || 
	    (!cpf.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}")) && 
	    (!cpf.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}/[0-9]{2}")) && 
	    (!cpf.matches("[0-9]{11}"))){
		System.out.println("Formato de CPF inválido.");
		return(false);
	    }
	String CPF = cpf.replaceAll("[\\.\\-/]", "");
        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere "0" no inteiro 0
        // (48 eh a posicao de "0" na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else {
		    System.out.println("CPF inválido.");
		    return(false);
	    }
	} 
	catch (InputMismatchException erro) {
			System.out.println("erro");
			return(false);

            }
        }

        public static String imprimeCPF(long CPF) {
		String aux = String.valueOf(CPF);
		if (aux.length() == 10){
				return("0" + aux.substring(0, 2) + "." + aux.substring(2, 5) + "." +
	    		aux.substring(5, 8) + "-" + aux.substring(8, 10));
		}
		else if (aux.length() == 11){
			return (aux.substring(0,3) + "." + aux.substring(3, 6) + "." + aux.substring(6, 9) +
					"-" + aux.substring(9, 11));
		}
		return "";

        }

	public static long toLong(String CPF){
		try{
			long newCPF = Long.parseLong(CPF.replaceAll("[\\.\\-/]", ""));
			return newCPF;
		}
		catch(NumberFormatException e){
			System.out.println("NumberFormatException: " + e.getMessage());
		}
		return -1;
	}
    }
