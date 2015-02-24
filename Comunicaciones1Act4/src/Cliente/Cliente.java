package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket s = new Socket("localhost", 5000);

		Scanner sc = new Scanner(System.in);

		// inicailizamos antes del bucle

		PrintWriter salidaAlServidor = new PrintWriter(s.getOutputStream(),
				true);
		BufferedReader entradaDesdeElServidor = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		int numeroN;
		do {

			System.out.println("Introduzca Numero");
			System.out.println("1--Buscar Fichero");
			System.out.println("2--Borrar Fichero");
			System.out.println("3--Crear Fichero");
			System.out.println("4--Listar Directorio");
			System.out.println("0--SALIR");
			String numero = sc.next();
			numeroN = Integer.parseInt(numero);
			// habilitamos la salida al servidor
			salidaAlServidor.println(numero);
			if (numeroN == 1 || numeroN == 2 || numeroN == 3 || numeroN == 4) {
				System.out.println("Introduzca Ruta");
				String ruta = sc.next();
				salidaAlServidor.println(ruta);
			}

			String mensajeServidor = entradaDesdeElServidor.readLine();

			System.out.println("El Servidor Dice: " + mensajeServidor);

		} while (numeroN != 0);

		// cierro todo
		salidaAlServidor.close();
		entradaDesdeElServidor.close();
		s.close();
		System.out.println("Cliente Desconectado");

	}

}
