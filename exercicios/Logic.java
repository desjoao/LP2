public class Logic {
	public static void main(String[] args) {

		// || or
		// && and
		// ! not

		boolean a = true || false;

		System.out.println(a);

		boolean b = true && false;

		System.out.println(b);

		boolean c = !true;

		System.out.println(c);

		int x = 1;
		int y = 4;
		boolean d = (x > y);
		boolean e = (x > y) || true;
		boolean f = (x > y) && true;

		System.out.println( d + "\n" + e + "\n" + f);

	}
}
