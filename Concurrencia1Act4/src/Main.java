
public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Hilo1 h1 = new Hilo1();
		Hilo2 h2 = new Hilo2();
		h1.start();				
		h1.yield();
		h1.join();
		h2.start();

	}

}
