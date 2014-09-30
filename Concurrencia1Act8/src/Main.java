import java.util.Scanner;

public class Main {

	private static Scanner sc;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("¿Cuantos Hijos Quiere Hacer?");
		sc = new Scanner(System.in);
		int hijos = sc.nextInt();
		
		for (int i=0;i<hijos;i++){
			Hilo h1 = new Hilo(i);
			h1.start();
		}

	}

}
