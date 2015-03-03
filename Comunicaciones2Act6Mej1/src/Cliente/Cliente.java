package Cliente;

import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	static final String HOST = "localhost";
	static final int PUERTO = 9000;
	Scanner sc;

	public Cliente() {
		try {
			Socket skCliente = new Socket(this.HOST, this.PUERTO); // se crea el
																	// socket
			System.out.println("Introduce tu Numbre ");
			sc = new Scanner(System.in);
			String nombre = sc.nextLine();
			Escribir hiloEscribir = new Escribir(skCliente, nombre);// hilo que escribe
			Leer hiloLeer = new Leer(skCliente);// hilo que lee
			while (hiloEscribir.isAlive() && hiloLeer.isAlive()) {

			}
			skCliente.close();// se cierra el socket
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] arg) {
		new Cliente();
	}
}
