package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

	private static Scanner s;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean terminarcliente = false;
		try {

				// conexion
				Socket s1 = new Socket("localhost", 5000);

				System.out.println("Nuevo Cliente");

				// Mensaje al Servidor
				PrintWriter salida = new PrintWriter(s1.getOutputStream(), true);

				// Mensaje del Servidor
				BufferedReader entradaDesdeElServidor = new BufferedReader(
						new InputStreamReader(s1.getInputStream()));

				int intentos = 0;

				while (!terminarcliente && intentos<3) {
						s = new Scanner(System.in);
						System.out.println("Introduzca Palabra");
						salida.println(s.nextLine());
						String entrada = entradaDesdeElServidor.readLine();
						System.out.println("El Servidor Dice: " + entrada);

						if (entrada.equalsIgnoreCase("Has Acertado")) {
							terminarcliente=true;
						} else if (entrada.equalsIgnoreCase("Has Fallado")) {
							intentos++;

						}
					}
				

				// cierro todo
				entradaDesdeElServidor.close();
				salida.close();
				s1.close();
				System.out.println("Cliente Desconectado");


		} catch (UnknownHostException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null,
					ex);
			System.out.println("Servidor no encontrado");
		} catch (IOException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null,
					ex);
			System.out.println("Error");
		}

	}

}
