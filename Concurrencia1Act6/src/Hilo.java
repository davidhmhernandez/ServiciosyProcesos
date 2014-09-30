import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hilo extends Thread {
	 private int i;
	private Scanner sc;

	    public Hilo(int i) {
	        super();
	        this.i=i+1; 
	    }

	    @Override
	    public void run() {
	        System.out.println("Empieza hilo" + this.i);
	        System.out.println("¿Quiere Hacer Otro Hilo? S/N");
	        sc = new Scanner(System.in);
	        String jov = sc.next();
	        if (jov.equalsIgnoreCase("S")) {
	            try {
	                Thread t1 = new Hilo(this.i);
	                t1.start();
	                t1.join();
	            } catch (InterruptedException ex) {
	                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
	            }

	        }
	        System.out.println(this.i + "termina");

	    }

}
