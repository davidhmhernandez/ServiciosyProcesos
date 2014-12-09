
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cueva c = new Cueva();
		Pirata p1 = new Pirata(c, "Jack Sparrow");
		Pirata p2 = new Pirata(c, "David Jones");
		Pirata p3 = new Pirata(c, "Barbarroja");
		Pirata p4 = new Pirata(c, "Hector Barbossa");
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();


	}

}
