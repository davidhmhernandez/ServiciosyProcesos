
public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Semaforo s = new Semaforo(3);
		Cliente c1 = new Cliente(s, "Cliente 1");
		Cliente c2 = new Cliente(s, "Cliente 2");
		Cliente c3 = new Cliente(s, "Cliente 3");
		Cliente c4 = new Cliente(s, "Cliente 4");
		Cliente c5 = new Cliente(s, "Cliente 5");
		Cliente c6 = new Cliente(s, "Cliente 6");
		Cliente c7 = new Cliente(s, "Cliente 7");
		Cliente c8 = new Cliente(s, "Cliente 8");
		Cliente c9 = new Cliente(s, "Cliente 9");
		Cliente c10 = new Cliente(s, "Cliente 10");
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();
		c7.start();
		c8.start();
		c9.start();
		c10.start();
		
			
		
		
		

	}

}
