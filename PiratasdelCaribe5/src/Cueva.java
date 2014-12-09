
public class Cueva {
	private int monedas = 1000;
	private int contadorPiratas = 0;
	private boolean terminado = false;
	private boolean p1,p2,p3,p4 = false;


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
			if (Thread.currentThread().getClass().getName().equals("Pirata")&& contadorPiratas<4 && monedas>0) {
				
				if(Thread.currentThread().getName().equals("Jack Sparrow")&& !p1){
					System.out.println("Entra "+Thread.currentThread().getName()+"  hay "
							+ (contadorPiratas + " Piratas"));
					this.setP1(true);
					correcto = true;
					contadorPiratas++;
				}else if (Thread.currentThread().getName().equals("David Jones")&& !p2){
					System.out.println("Entra "+Thread.currentThread().getName()+"  hay "
							+ (contadorPiratas + " Piratas"));
					this.setP2(true);
					correcto = true;
					contadorPiratas++;
				}else if(Thread.currentThread().getName().equals("Barbarroja")&& !p3){
					System.out.println("Entra "+Thread.currentThread().getName()+"  hay "
							+ (contadorPiratas + " Piratas"));
					this.setP3(true);
					correcto = true;
					contadorPiratas++;
				}else if(Thread.currentThread().getName().equals("Hector Barbossa")&& !p4){
					System.out.println("Entra "+Thread.currentThread().getName()+"  hay "
							+ (contadorPiratas + " Piratas"));
					this.setP4(true);
					correcto = true;
					contadorPiratas++;
				}else {
					try {
						this.wait(1000);
						correcto = false;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else if(contadorPiratas==4){
				p1=false;
				p2=false;
				p3=false;
				p4=false;
				contadorPiratas =0;
				correcto = true;
				
			} else {
				System.out.println(Thread.currentThread().getName()
						+ " espera ");
				try {
					this.wait();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				correcto = false;
			}

		} while (!correcto);
	}

	public synchronized void soltar() {
		if (Thread.currentThread().getClass().getName().equals("Pirata")) {
			
			System.out.println("Sale "+Thread.currentThread().getName()+" hay "
					+ (contadorPiratas + " Piratas"));

		}

		notify();
	}

	public boolean isTerminado() {
		return terminado;
	}

	public boolean isP1() {
		return p1;
	}

	public void setP1(boolean p1) {
		this.p1 = p1;
	}

	public boolean isP2() {
		return p2;
	}

	public void setP2(boolean p2) {
		this.p2 = p2;
	}

	public boolean isP3() {
		return p3;
	}

	public void setP3(boolean p3) {
		this.p3 = p3;
	}

	public boolean isP4() {
		return p4;
	}

	public void setP4(boolean p4) {
		this.p4 = p4;
	}
}
