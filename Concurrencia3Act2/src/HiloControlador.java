public class HiloControlador extends Thread {
	private Sincronizaor sinc;

	public HiloControlador(Sincronizaor sinc) {
		this.sinc = sinc;
	}

	@Override
	public void run() {
		for (;;) {
			sinc.adquirir();

			if (sinc.getTemperatura() > 20 && sinc.getHumedad() > 40
					&& sinc.getLuz() > 50) {
				System.out.println("Hace Calor");
			} else {
				System.out.println("Hace Frio");
			}

			sinc.soltar();
		}

	}
}
