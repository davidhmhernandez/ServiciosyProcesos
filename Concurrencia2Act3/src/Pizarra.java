public class Pizarra {
	private int contadorCambioNumero = 0;
	private int numeroEscrito = 0;

	
	
	

	public int getNumeroEscrito() {
		return numeroEscrito;
	}

	public void setNumeroEscrito(int numeroEscrito) {
		this.numeroEscrito = numeroEscrito;
	}

	public int getContadorCambioNumero() {
		return contadorCambioNumero;
	}

	public void setContadorCambioNumero(int contadorCambioNumero) {
		this.contadorCambioNumero = contadorCambioNumero;
	}
	public void aumentarContador(){
		this.contadorCambioNumero++;
	}
	
}
