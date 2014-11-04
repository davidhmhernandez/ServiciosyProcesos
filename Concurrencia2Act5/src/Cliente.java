public class Cliente extends Thread {
	Semaforo semaforo = null;
	


	public Cliente(Semaforo s, String st) {
		super(st);
		this.semaforo = s;
	}

	@Override
	public void run() {

		semaforo.adquirir();
		System.out.println("Yo " + Thread.currentThread().getName()
				+ " Entro a Comprar");
		int r = (int) (Math.random() * (4) + 1);
		System.out.println(Thread.currentThread().getName()
				+ " Compra Durante " + r + " Segundos");

		
		synchronized (semaforo) {
			try {
				semaforo.wait(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		semaforo.soltar();
		System.out.println(Thread.currentThread().getName() + " Sale ");
		if(semaforo.getContadorClientes()==10){
			System.out.println("Total Recaudado: "+semaforo.getTotal()+" Euros");
		}
		
		
	}

}
