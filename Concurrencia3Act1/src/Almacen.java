public class Almacen {
	private int galletas = 10;
	private boolean terminado = false;
	private int contadorMounstruos = 0;
	private boolean estaAlmacenero = false;

	public Almacen() {
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	/**
	 * Comer Galletas
	 */
	public void comer(int i) {
		this.galletas = this.galletas - i;
		if (this.galletas < 0)
			galletas = 0;
		System.out.println("Hemos comido " + i + " quedan " + this.galletas);
	}

	/**
	 * Reponer Galletas
	 */
	public void reponer() {
		this.galletas = 10;
		System.out.println("Reponemos hay " + this.galletas);
	}

	/**
	 * @return the galletas
	 */
	public int getGalletas() {
		return galletas;
	}

	/**
	 * @param galletas
	 *            the galletas to set
	 */
	public void setGalletas(int galletas) {
		this.galletas = galletas;
	}

	// Para bloquear
	public synchronized void adquirir() {
		// System.out.println(Thread.currentThread().getClass().getName());

		boolean correcto = false;
		do {
			
			if (Thread.currentThread().getClass().getName().equals("Mounstruo")
					&& !estaAlmacenero) {
				contadorMounstruos++;
				System.out.println("Entra Monstruo hay "
						+ (contadorMounstruos + " Mounstruos"));
				correcto=true;

			} else if (Thread.currentThread().getClass().getName()
					.equals("Almecenero")
					&& contadorMounstruos == 0) {
				System.out.println("Entra Almacenero");
				estaAlmacenero=true;
				
				correcto=true;
			} else {
				System.out.println(Thread.currentThread().getClass().getName()
						+ " espera ");
				
				
				try {
					System.out.println(contadorMounstruos);
					wait();
//					if(Thread.currentThread().getClass().getName().equals("Mounstruo"))
//						{contadorMounstruos++;
//					System.out.println("Despierta Monstruo hay "+contadorMounstruos);
//					}else
//						{estaAlmacenero = true;
//						System.out.println("Despierta Almacenero");
//						
//						}
					correcto = false;

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} while (!correcto);
	}

	// Para liberar
	public synchronized void soltar() {

		if (Thread.currentThread().getClass().getName().equals("Mounstruo")) {
			contadorMounstruos--;
			System.out.println("Sale Monstruo hay "
					+ (contadorMounstruos + " Mounstruos"));
		
		} else {
			System.out.println("Sale Almacenero");
			estaAlmacenero = false;
		}

		notify();

	}
}
