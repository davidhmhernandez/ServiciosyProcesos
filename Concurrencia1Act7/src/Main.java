import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t1 = new Hilo(0);
        t1.start();  
        try {
            t1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }


	}

}
