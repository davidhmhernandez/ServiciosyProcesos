public class Pirata extends Thread {
	Cueva c = null;
	private int monedasRobadas;

	public Pirata(Cueva c, String st) {
		super(st);
		this.c = c;

	}

	@Override
	public void run() {
		for (;;) {
			if (c.getMonedas() > 0) {
				c.adquirir();
				c.quitarMoneda();
				monedasRobadas++;
				c.soltar();
			} else
				c.setTerminado(true);

			if (c.isTerminado())
				break;

		}
		System.out.println(Thread.currentThread().getName() + " termino ok"
				+ " Monedas Robadas: " + monedasRobadas);
	}
}
