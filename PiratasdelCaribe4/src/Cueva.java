public class Cueva {
	private int monedas = 1000;
	private int contadorPiratas = 0;
	private boolean terminado = false;

	public int getMonedas() {
		return monedas;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}

	public void quitarMoneda() {
		if (monedas > 0) {
			monedas--;
			System.out.println(Thread.currentThread().getName() + " ROBA "
					+ " Quedan " + getMonedas() + " Monedas");
		} else
			System.out.println("NO Hay Monedas");
	}

	public synchronized void adquirir() {
		boolean correcto = false;
		do {
			if(monedas>0){
			if (Thread.currentThread().getClass().getName().equals("Pirata")&& contadorPiratas<2) {
				contadorPiratas++;
				System.out.println("Entra "+Thread.currentThread().getName()+"  hay "
						+ (contadorPiratas + " Piratas"));
				correcto = true;
			} else {
				System.out.println(Thread.currentThread().getName()
						+ " espera ");
				try {
					this.wait();
					correcto = false;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}

		} while (!correcto);
	}

	public synchronized void soltar() {
		if (Thread.currentThread().getClass().getName().equals("Pirata")) {
			contadorPiratas--;
			System.out.println("Sale "+Thread.currentThread().getName()+" hay "
					+ (contadorPiratas + " Piratas"));

		}

		notify();
	}

	public boolean isTerminado() {
		return terminado;
	}
	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}
}
