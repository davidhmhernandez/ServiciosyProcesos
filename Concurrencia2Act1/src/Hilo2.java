import java.util.logging.Level;
import java.util.logging.Logger;


public class Hilo2 extends Thread {
	static final Object monitor = new Object();

    @Override
    public void run() {
        
        synchronized (monitor) {
            for (int i = 100; i > 0; i--) {
               monitor.notify();
                System.out.println("Hilo 2");
                System.out.println(i);
                try {
                    sleep(500);
                    monitor.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            monitor.notify();
        }
    }
}
