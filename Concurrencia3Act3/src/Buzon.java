public class Buzon {

	private static final int MAX_MENSAJES = 10;
	String lista[] = new String[MAX_MENSAJES];

	void escribir(Mensaje msg) {

	}

	String leer() {
		if (lista.length < 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Thread.currentThread().getName()+" Suspendido";
		} else
			return "Leido";

	}

}
