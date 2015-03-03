package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClienteConectado extends Thread {
	private static ArrayList<Socket> listaCliente = new ArrayList<Socket>();
	private Socket socket;

	public ClienteConectado(Socket socket) {
		listaCliente.add(socket);
		this.socket = socket;
		start();
	}

	public void run() {
		try {
			boolean terminar = false;
			while (true) {
				String mensaje = escuchar();
				reenviar(terminar, mensaje);
			}
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

	private void reenviar(boolean terminar, String mensaje) {
		OutputStream os;
		try {
			for (int cont = 0; cont < listaCliente.size(); cont++) {
				os = listaCliente.get(cont).getOutputStream();
				DataOutputStream flujoDOS = new DataOutputStream(os);
				flujoDOS.writeUTF(mensaje);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String escuchar() throws IOException {
		InputStream aux = socket.getInputStream();
		DataInputStream flujo = new DataInputStream(aux);
		return flujo.readUTF();
	}
}