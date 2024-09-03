import java.time.LocalDate;
import java.time.Period;

public class SuaIdade{
	public static void main(String[] args){

		LocalDate today = LocalDate.now();
		LocalDate birthDate = LocalDate.of(1996, 12, 17);
		int years = Period.between(birthDate, today).getYears();
		int months = Period.between(birthDate, today).getMonths();
		int days = Period.between(birthDate, today).getDays();

		System.out.println(today);
		System.out.println(birthDate);
		System.out.print(years + " anos, ");
		System.out.print(months + " meses e ");
		System.out.print(days + " dias.   ");
	}
}

