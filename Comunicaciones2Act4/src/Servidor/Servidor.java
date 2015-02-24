package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {
	private ServerSocket ss;
	private Socket s;
	private Contador c;
	String palabra = "Torvall";

	public Servidor(ServerSocket ss, Socket s, Contador c) {
		this.s = s;
		this.ss = ss;
		this.c = c;
	}

	@Override
	public void run() {

		System.out.println(palabra);
		PrintWriter salidaAlCliente = null;
		String palabraRecibida;

		try {
			// inicializamos la salida y entrada del cliente
			BufferedReader entradaDesdeElCliente = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			salidaAlCliente = new PrintWriter(s.getOutputStream(), true);
			do {
				salidaAlCliente.println("Introduzca Palabra");
				palabraRecibida = entradaDesdeElCliente.readLine();
			} while (!palabraRecibida.equalsIgnoreCase(palabra)
					&& !c.isAcertado());

			if (palabraRecibida.equalsIgnoreCase(palabra)) {
				salidaAlCliente.println("Acierto");
				c.heAcertado();

			} else {
				salidaAlCliente.println("Otro Cliente ha Acertado");

			}

			c.muero();
			System.out.println(c.getContador());
			entradaDesdeElCliente.close();
			salidaAlCliente.close();
			s.close();
			if (c.vacio()) {

				ss.close();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			salidaAlCliente.println("Error Irrecuperable");
		}
	}

}
