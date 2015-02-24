package Servidor;

public class Tarjeta {
	private int numero = 0;
	private int clave = 0;
	private double saldo = 0;

	public Tarjeta(int numero, int clave, int saldo) {
		this.numero = numero;
		this.clave = clave;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		String x = "";
		x += "Numero: " + this.numero;
		x += "\nSaldo: " + this.saldo;
		return x;
	}
}
