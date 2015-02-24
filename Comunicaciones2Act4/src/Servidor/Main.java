package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {
		ServerSocket ss;
		System.out.println("Arrancando ");
		Contador c = new Contador();

		try {
			ss = new ServerSocket(5000);
			do {

				Socket s;
				s = ss.accept();
				c.nuevo();
				Servidor server = new Servidor(ss, s, c);
				server.start();

			} while (true);
		} catch (IOException e) {
			System.out.println("Programa Terminado");
		}

	}

}
