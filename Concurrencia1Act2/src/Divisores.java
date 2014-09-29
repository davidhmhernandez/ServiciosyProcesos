public class Divisores extends Thread {
	public Divisores(int i) {

	}

	@Override
	public void run() {
		int i = 0;
		int cont = 0;
		for (int a = 1; a <= i; a++) {
			if ((i % a) == 0) {
				cont++;

			}
		}
		System.out.print(" " + cont + " ");
	}

}
