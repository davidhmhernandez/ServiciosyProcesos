package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(5000);
		System.out.println("Arrancado");
		Socket s = ss.accept();
		System.out.println("Nuevo Cliente");

		// inicializamos la salida y entrada del cliente
		BufferedReader entradaDesdeElCliente = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		PrintWriter salidaAlCliente = new PrintWriter(s.getOutputStream(), true);

		boolean fin = false;
		do {
			// habilitamos la entrada desde el cliente
			String mensaje = entradaDesdeElCliente.readLine();
			System.out.println("El Cliente dice: " + mensaje);

			if (mensaje.equalsIgnoreCase("fin")){
				fin = true;
			}

			// Habilitamos la salida al cliente
			if(fin==true){
				
			}else{
			System.out.println("Introduzca Palabra");
			Scanner sc = new Scanner(System.in);
			String mensaje2 = sc.next();
			salidaAlCliente.println(mensaje2);
			}


		} while (!fin);

		// fin de la conexión
		entradaDesdeElCliente.close();
		salidaAlCliente.close();
		s.close();
		ss.close();
		System.out.println("Servidor Desconectado");

	}

}
