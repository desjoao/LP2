import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class SuaIdade{
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);

		System.out.println("Digite o dia em que você nasceu:");
		int dia = scan.nextInt();

		System.out.println("Digite o mês em que você nasceu:");
		int mes = scan.nextInt();

		System.out.println("Digite o ano em que você nasceu:");
		int ano = scan.nextInt();

		LocalDate today = LocalDate.now();
		LocalDate birthDate = LocalDate.of(ano, mes, dia);
		int years = Period.between(birthDate, today).getYears();
		int months = Period.between(birthDate, today).getMonths();
		int days = Period.between(birthDate, today).getDays();

		System.out.println("\nHojé é " + today);
		System.out.println("\nVocê nasceu em " + birthDate);
		System.out.println("\nVocê possui...");
		System.out.print(years + " anos, ");
		System.out.print(months + " meses e ");
		System.out.println(days + " dias.\n\n");
	}
}
