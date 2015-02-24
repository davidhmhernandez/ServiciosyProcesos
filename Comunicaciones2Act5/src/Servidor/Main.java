package Servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {

		try {
			// conexión de 1 cliente
			ServerSocket ss = new ServerSocket(5000);
			System.out.println("Arrancado");

			Socket s = ss.accept();
			System.out.println("Conectado cliente");

			// Habilitamos la salida al cliente
			PrintWriter salidaAlCliente = new PrintWriter(s.getOutputStream(),
					true);

			for (int i = 0; i < 3; i++) {
				salidaAlCliente.println("Hola Holita " + i);
				try {
					int tiempo = ((int) ((Math.random() * 6) + 1)) * 1000;
					System.out.println("tiempo " + tiempo);
					Thread.sleep(tiempo);
				} catch (InterruptedException ex) {
					Logger.getLogger(Main.class.getName()).log(Level.SEVERE,
							null, ex);
				}
			}

			// fin de la conexión
			salidaAlCliente.close();
			s.close();
			ss.close();
			System.out.println("Desconectado");

		} catch (IOException ex) {
			System.out.println("Error");
		}

	}

}
