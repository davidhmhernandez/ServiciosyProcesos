public class HiloSensor extends Thread {
	Sincronizaor hc = null;

	private static int dato = 0;

	public HiloSensor(Sincronizaor hc, String st) {
		super(st);
		this.hc = hc;
	}

	public static int getdato() {
		return dato;
	}

	@Override
	public void run() {

		for (;;)

		{
			hc.adquirir();
			dato = (int) (Math.random() * (45));
			hc.soltar();
		}

	}

}
