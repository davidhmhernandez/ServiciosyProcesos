public class Pirata extends Thread {
	Cueva c = null;
	private boolean pirataDentro = false;
	private int monedasRobadas;

	public Pirata(Cueva c, String st) {
		super(st);
		this.c = c;

	}

	@Override
	public void run() {
		do {
			synchronized (c) {
				c.notify();
				if (!pirataDentro) {
					pirataDentro = true;
					c.quitarMoneda();
					monedasRobadas++;
					pirataDentro = false;
					

				}
				if (pirataDentro) {
					try {
						c.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()
							+ " esta Dentro");
				}
			}

		} while (c.getMonedas() > 0);
		
		System.out.println("Sale "
				+ Thread.currentThread().getName()+ " Monedas Robadas: "+monedasRobadas);
	}

}
