import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo1 extends Thread {

    @Override
    public void run() {
       
        Hilo2 h2 = new Hilo2();
        synchronized (h2.monitor) {
            for (int i = 0; i < 101; i++) {
                h2.monitor.notify();
                 System.out.println("Hilo 1");
                System.out.println(i);
                
                try {
                    sleep(500);
                    h2.monitor.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            h2.monitor.notify();
        }
    }
}
