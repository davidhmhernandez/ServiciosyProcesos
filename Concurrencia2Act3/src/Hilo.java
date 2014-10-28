public class Hilo extends Thread {
	Pizarra p = null;
	int numero;
	int contador = 0;

	public Hilo(Pizarra p, int numero) {
		this.numero = numero;
		this.p = p;

	}

	@Override
	public void run() {
		do {
			synchronized (p) {
				p.notify();
				if (numero == p.getNumeroEscrito()) {

					int r = (int) (Math.random() * (3));
					System.out.println("Numero Escrito " + p.getNumeroEscrito()
							+ " Yo Hilo " + numero + " Escribo " + r);
					p.setNumeroEscrito(r);
					p.aumentarContador();
					contador++;

				}
				if (p.getContadorCambioNumero() < 10) {
					try {
						p.wait();

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		} while (p.getContadorCambioNumero() < 10);

	}

	public int getContador() {
		return contador;
	}

}
