
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sincronizaor sinc = new Sincronizaor();
		HiloSensor hs1 = new HiloSensor(sinc, "Hilo Sensor 1");
		HiloSensor hs2 = new HiloSensor(sinc, "Hilo Sensor 2");
		HiloSensor hs3 = new HiloSensor(sinc, "Hilo Sensor 3");
		HiloControlador hc = new HiloControlador(sinc);

		hs1.start();

		hs2.start();

		hs3.start();

		hc.start();

	}

}
