package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		try {
			// conectamos
			ServerSocket ss1 = new ServerSocket(5000);
			System.out.println("Arrancado");

			boolean acertado = false;
			int intentos = 0;

			while (!acertado) {

				Socket s1 = ss1.accept();
				System.out.println("Nuevo Cliente");

				// La entrada
				BufferedReader entrada = new BufferedReader(
						new InputStreamReader(s1.getInputStream()));
				PrintWriter salidaAlCliente = new PrintWriter(
						s1.getOutputStream(), true);

				while (!acertado && intentos < 3) {
					String aux = entrada.readLine();
					System.out.println("El Cliente Dice: " + aux);

					if (aux.equalsIgnoreCase("Madrid")) {
						salidaAlCliente.println("Has Acertado");
						acertado = true;

					} else {
						salidaAlCliente.println("Has Fallado");
						intentos++;
						System.out.println(intentos);
					}
				}

				// fin

				intentos = 0;
				entrada.close();
				salidaAlCliente.close();
				s1.close();

			}
			System.out.println("Servidor Desconectado");
			ss1.close();

		} catch (IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null,
					ex);
			System.out.println("Error");
		}
	}
}
