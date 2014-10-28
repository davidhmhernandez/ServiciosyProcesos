import java.io.ObjectInputStream.GetField;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pizarra p = new Pizarra();
		Hilo h1 = new Hilo(p, 0);
		Hilo h2 = new Hilo(p, 1);
		Hilo h3 = new Hilo(p, 2);
		h1.start();
		h2.start();
		h3.start();
	
		try {
			h1.join();
			h2.join();
			h3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hilo 0: " + h1.getContador());
		System.out.println("Hilo 1: " + h2.getContador());
		System.out.println("Hilo 2: " + h3.getContador());

	}

}
