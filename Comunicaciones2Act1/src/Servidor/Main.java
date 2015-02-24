package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		ServerSocket ss;
		System.out.println("Arrancando ");
		int contador =0;

		try {
			ss = new ServerSocket(5000);
			
			Semaphore semaphore = new Semaphore(2);
			
			do {
				Socket s;
				s = ss.accept();
				Servidor server = new Servidor(ss, s,semaphore);
				server.start();
				contador++;

				// finalizar con una opcion
			} while (contador<2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
