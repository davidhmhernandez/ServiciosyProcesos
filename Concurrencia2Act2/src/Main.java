import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Monitor monitor = new Monitor();
        Hilo1 h1 = new Hilo1(monitor);

        h1.start();
        Hilo1 h2 = new Hilo1(monitor);

        h2.start();
        try {
            h1.join();
            h2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

}
