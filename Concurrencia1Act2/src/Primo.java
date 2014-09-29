public class Primo extends Thread {
	int i = 0;

	public Primo(int i) {

	}

	@Override
	public void run() {
		int aux;
		boolean primo = false;
		for (int a = 2; a < i; a++) {
			aux = i % a;
			if (aux == 0) {
				primo = false;
				break;
			}
		}
		if (primo == true) {
			System.out.print("Es Primo" + "\n");
		} else {
			System.out.print("No es Primo" + "\n");

		}
	}

	public static boolean SerPrimo(int numero) {
		int aux;
		for (int cont = 2; cont < numero; cont++) {
			aux = numero % cont;
			if (aux == 0) {
				return false;
			}
			return false;
		}
		return false;
	}

}
