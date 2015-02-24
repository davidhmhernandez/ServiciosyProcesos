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

		boolean fin = false;
		do {
			
			System.out.println("Introduzca Palabra");
			String mensaje = sc.next();

			if (mensaje.equalsIgnoreCase("fin")) {
				fin = true;
			}

			// habilitamos la salida al servidor
			salidaAlServidor.println(mensaje);

			String mensajeServidor = entradaDesdeElServidor.readLine();

			System.out.println("El Servidor Dice: " + mensajeServidor);
			
			if (mensajeServidor.equalsIgnoreCase("fin")){
				fin = true;
			}
			if(fin==true){
				
			}

		} while (!fin);

		// cierro todo
		salidaAlServidor.close();
		entradaDesdeElServidor.close();
		s.close();
		System.out.println("Cliente Desconectado");

	}

}
