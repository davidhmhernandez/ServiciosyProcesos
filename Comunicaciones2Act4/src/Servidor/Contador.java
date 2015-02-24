package Servidor;

public class Contador {

	private int contador = 0;
	private boolean acertado = false;

	public synchronized void nuevo() {
		contador++;
	}

	public synchronized void muero() {
		contador--;
	}

	public int getContador() {
		return contador;
	}

	public boolean vacio() {
		if (contador == 0) {
			return true;
		}
		return false;
	}
	public synchronized void heAcertado(){
		acertado = true;
	}
	public boolean isAcertado(){
		return acertado;
	}
}
