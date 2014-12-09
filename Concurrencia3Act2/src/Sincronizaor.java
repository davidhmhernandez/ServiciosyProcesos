public class Sincronizaor {
	private int contadorHilosSensor = 0;
	private int temperatura, humedad, luz;
	private boolean temp,hum,lu = false;




	// Para bloquear
	public synchronized void adquirir() {
		boolean correcto = false;
		do {
			

			if (Thread.currentThread().getClass().getName()
					.equals("HiloSensor")
					&& contadorHilosSensor < 3) {
				if (Thread.currentThread().getName().equals("Hilo Sensor 1") && !temp) {
					
					this.setTemp(true);
					this.setTemperatura(HiloSensor.getdato());					
					System.out.println("Temperatura: " + this.getTemperatura());
					correcto = true;
					contadorHilosSensor++;
				} else if (Thread.currentThread().getName().equals("Hilo Sensor 2") && !hum) {
					this.setHum(true);
					this.setHumedad(HiloSensor.getdato());	
					System.out.println("Humedad: " + this.getHumedad());
					correcto = true;
					contadorHilosSensor++;
				} else if (Thread.currentThread().getName().equals("Hilo Sensor 3") && !lu){
					this.setLu(true);
					this.setLuz(HiloSensor.getdato());
					System.out.println("Luz: " + this.getLuz());
					correcto = true;
					contadorHilosSensor++;
					
				}else{
					try {
						this.wait(1000);
						correcto = false;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (Thread.currentThread().getClass().getName()
					.equals("HiloControlador")
					&& contadorHilosSensor == 3) {
				System.out.println("Entra Hilo Controlador");
				temp=false;
				hum=false;
				lu=false;
				contadorHilosSensor = 0;
				correcto = true;

			} else {
				System.out.println(Thread.currentThread().getClass().getName()
						+ " Espera ");
				try {
//					notify();
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				correcto = false;
			}
		} while (!correcto);

	}

	// Para liberar
	public synchronized void soltar() {
		notify();

	}

	public int getContadorHilos() {
		return contadorHilosSensor;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public int getHumedad() {
		return humedad;
	}

	public void setHumedad(int humedad) {
		this.humedad = humedad;
	}

	public int getLuz() {
		return luz;
	}

	public void setLuz(int luz) {
		this.luz = luz;
	}
	
	public boolean isTemp() {
		return temp;
	}

	public void setTemp(boolean temp) {
		this.temp = temp;
	}

	public boolean isHum() {
		return hum;
	}

	public void setHum(boolean hum) {
		this.hum = hum;
	}

	public boolean isLu() {
		return lu;
	}

	public void setLu(boolean lu) {
		this.lu = lu;
	}

}
