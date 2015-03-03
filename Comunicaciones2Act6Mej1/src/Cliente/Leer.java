package Cliente;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class Leer extends Thread {
	private Socket socket;

	public Leer(Socket socket) {
		super("Hilo leer");
		this.socket = socket;
		start();
	}

	public void run() {
		try {
			while (true) {
				InputStream aux = socket.getInputStream();
				DataInputStream flujo = new DataInputStream(aux);
				System.out.println(flujo.readUTF());
			}
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
}
