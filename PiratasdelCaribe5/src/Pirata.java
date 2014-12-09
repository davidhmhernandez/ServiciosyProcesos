
public class Pirata extends Thread {
	Cueva c = null;

	public Pirata(Cueva c, String st) {
		super(st);
		this.c = c;

	}
	@Override
	public void run() {
		
		for(;;){
			c.adquirir();
			c.quitarMoneda();
			c.soltar();
			
			
		}
		
	}
}
