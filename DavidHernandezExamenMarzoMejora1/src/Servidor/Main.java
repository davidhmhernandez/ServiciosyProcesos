package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ServerSocket ss;
		System.out.println("Arrancando ");
		int cont = 0;
		ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
		ArrayList<String> nombres = new ArrayList<String>();

		try {
			ss = new ServerSocket(9000);
			do {
				Socket s;
				s = ss.accept();
				Servidor server = new Servidor(ss, s, mensajes,nombres);
				server.start();
				cont++;

				// finalizar con una opcion
			} while (cont < 3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
