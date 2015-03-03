package Servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	static final int PUERTO = 9000;
	private ServerSocket ss;
	private ClienteConectado cliente;

	public Servidor() {
		try {
			ss = new ServerSocket(PUERTO);
			for (int clientes = 0; clientes < 5; clientes++) {
				Socket s = ss.accept();
				System.out.println("Numero de Clientes: " + clientes);
				cliente = new ClienteConectado(s);
			}
			System.out.println("Servidor To Petao");
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}

	public static void main(String[] arg) {
		new Servidor();
	}

}
