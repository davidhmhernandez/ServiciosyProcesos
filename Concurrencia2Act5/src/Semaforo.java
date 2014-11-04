public class Semaforo {
	private int contador = 0;
	private int total = 0;
	private int contadorClientes=0;

	public int getContadorClientes() {
		return contadorClientes;
	}

	public int getContador() {
		return contador;
	}

	public int getTotal() {
		return total;
	}

	public Semaforo(int num) {
		this.contador = num;
	}

	// Para bloquear
	public synchronized void adquirir() {

		if (contador > 0) {
			contador--;
			System.out.println("Entra cliente ");
			

		} else {
			System.out.println("Cliente espera ");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// Para liberar
	public synchronized void soltar() {

		contador++;
		contadorClientes++;
		System.out.println("contador clientes "+contadorClientes);
		notify();
		int cuenta = (int) (Math.random() * (10));
		System.out.println(Thread.currentThread().getName() + " Paga " + cuenta
				+ " Euros.");
		total += cuenta;

	}

}
