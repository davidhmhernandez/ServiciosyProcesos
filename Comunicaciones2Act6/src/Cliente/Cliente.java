package Cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	private Socket socket = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	BufferedReader entradaDesdeElCliente = null;

	public Cliente(String servidor, int puerto) {
		try {
			socket = new Socket(servidor, puerto);
			System.out.println("Conectado");
			start();
		} catch (UnknownHostException uhe) {
			System.out.println("Host unknown: " + uhe.getMessage());
		} catch (IOException ioe) {
			System.out.println("Unexpected exception: " + ioe.getMessage());
		}
		String texto = "";
		String palabraRecibida;
		
		try {
			entradaDesdeElCliente = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (!texto.equalsIgnoreCase("adios")) {
			try {
				System.out.println("Introduzca Mensaje: " );
				texto = dis.readLine();
				dos.writeUTF(texto);
				dos.flush();
				palabraRecibida=entradaDesdeElCliente.readLine();
				System.out.println(palabraRecibida);
				
				
				
			} catch (IOException ioe) {
				System.out.println("Sending error: " + ioe.getMessage());
			}
		}
	}

	private void start() throws IOException {
		dis = new DataInputStream(System.in);
		dos = new DataOutputStream(socket.getOutputStream());
	}

	public void stop() {
		try {
			if (dis != null)
				dis.close();
			if (dos != null)
				dos.close();
			if (socket != null)
				socket.close();
		} catch (IOException ioe) {
			System.out.println("Error closing ...");
		}
	}

	public static void main(String[] args) {
		Cliente client = new Cliente("localhost", Integer.parseInt("8080"));
	}

}
