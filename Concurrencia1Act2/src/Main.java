import java.util.Scanner;

public class Main {

	private static Scanner teclado;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Introduzca el Numero.");
		teclado = new Scanner(System.in);
		int i = 0;
		while ((i = teclado.nextInt()) > 0) {
			Thread t1 = new Primo(i);
			Thread t2 = new Divisores(i);
			t1.start();
			t2.start();

		}

	}
}
