
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cueva c = new Cueva();
		Pirata p1 = new Pirata(c, "Jack Sparrow");
		
		Pirata p2 = new Pirata(c, "David Jones");
		
		
		p1.start();
		p2.start();
	
		try {
			p1.join();
			p2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
