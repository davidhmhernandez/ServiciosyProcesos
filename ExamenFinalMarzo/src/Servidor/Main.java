package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Supermercado.Usuario;


public class Main {

	public static void main(String[] args) {
		ServerSocket ss;
		System.out.println("Arrancando el Servidor ");
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			ss = new ServerSocket(5000);
			do {
				Socket s;
				s = ss.accept();
				Servidor server = new Servidor(ss, s, usuarios);
				server.start();

				// finalizar con una opcion
			} while (true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
