public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Object monitor = new Object();
		
		Hilo1 hilo1 = new Hilo1(monitor);
		Hilo2 hilo2 = new Hilo2(monitor);

		hilo1.start();
		hilo2.start();
		
		

	}

}
