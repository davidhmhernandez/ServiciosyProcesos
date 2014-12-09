
public class Pirata extends Thread {
	Cueva c = null;
	private int monedasRobadas;

	public Pirata(Cueva c, String st) {
		super(st);
		this.c = c;

	}
	@Override
	public void run() {
		synchronized (c) {
			boolean sigue = true;
			while (sigue) {
				c.quitarMoneda();
				monedasRobadas++;
				if(c.getMonedas()==0){
					System.out.println("Adios "+Thread.currentThread().getName());
					c.notify();
					c.setMuerto(true);
					sigue = false;
				}else if(c.getMuerto()==false ){
					c.notify();
					try {
						System.out.println("Duerme "+Thread.currentThread().getName());
						c.wait();
						
					} catch (InterruptedException ex) {
					}
				}
			}
		}
		System.out.println("Sale "
				+ Thread.currentThread().getName()+ " Monedas Robadas: "+monedasRobadas);
	}
}
