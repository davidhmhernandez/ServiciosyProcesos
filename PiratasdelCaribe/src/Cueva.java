
public class Cueva {
	private int monedas =1000;
	


	public int getMonedas() {
		return monedas;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}   
	
	public void quitarMoneda(){
		if (monedas>0){
			monedas--;
			System.out.println(Thread.currentThread().getName()+" ROBA "+ " Quedan "+getMonedas()+" Monedas");
		}else System.out.println("NO Hay Monedas");
	}

}
