package Banco;

public class Tarjeta {
	private int numero;
	private int clave;
	private double saldo;

	
	
	public Tarjeta(int numero, int clave, double saldo) {
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
	
	public String toString(){
		String s ="Numero: "+numero;
		s+=" Clave: "+clave;
		s+=" Saldo: "+saldo;
		return s;
	}

}
