import java.util.Random;


public class Jugador extends Thread {
	   String objeto1 = "Piedra";
	    String objeto2 = "Papel";
	    String objeto3 = "Tijeras";
	    String valorJ1;

	    public Jugador() {
	    }

	    @Override
	    public void run() {
	        palabraAleatoria();
	    }

	    public void palabraAleatoria() {
	        valorJ1=objeto3;
	        Random r = new Random();

	        int n = r.nextInt(3); //un random de 0 a 2

	        if (n == 1) {
	            valorJ1=objeto1;
	        } else if (n == 2) {
	            valorJ1=objeto1;
	        }
	        //return valorJ1;
	    }

}
