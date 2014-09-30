import java.util.logging.Level;
import java.util.logging.Logger;


public class Hilo extends Thread {
	private static boolean terminado;
    private int i;
    private int guiones;

    public Hilo(int i) {
        super();
        this.i = i + 1;
        this.guiones=i+1;
    }

    @Override
    public void run() {
        System.out.println("Empieza hilo" + this.i);
        if(this.i==20){
            terminado=true;
        }
        for(;terminado==false;){
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
