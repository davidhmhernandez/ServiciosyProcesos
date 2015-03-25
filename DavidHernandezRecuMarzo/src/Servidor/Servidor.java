package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {

		ServerSocket ss = new ServerSocket(5000);
		System.out.println("Arrancado");
		Socket s = ss.accept();
		System.out.println("Nuevo Cliente");

		// inicializamos la salida y entrada del cliente
		BufferedReader entradaDesdeElCliente = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		PrintWriter salidaAlCliente = new PrintWriter(s.getOutputStream(), true);
	}

}
