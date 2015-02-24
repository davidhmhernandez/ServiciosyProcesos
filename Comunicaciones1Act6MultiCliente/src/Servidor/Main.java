package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket ss;
		System.out.println("Arrancando ");
		int cont = 0;
		ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		
		
		
		
		
		
		try {
			ss = new ServerSocket(5000);
			do {
				Socket s;
				s = ss.accept();
				Servidor server = new Servidor(ss, s, tarjetas);
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
