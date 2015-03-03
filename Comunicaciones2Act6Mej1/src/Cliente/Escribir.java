package Cliente;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Escribir extends Thread {
	private Socket socket;
	private String name;

	public Escribir(Socket socket, String name) {
		super("Hilo escribir");
		this.socket = socket;
		this.name = name;
		start();
	}

	public void run() {
		try {
			boolean terminar = false;
			while (!terminar) {
				OutputStream os = socket.getOutputStream();
				DataOutputStream flujoDOS = new DataOutputStream(os);
				 String mensaje=Entrada.cadena();
				if (mensaje.equals("salir")) {
					terminar = true;
				} else {
					flujoDOS.writeUTF(name + " dice: " + mensaje);
				}
			}
			socket.close();
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
}
