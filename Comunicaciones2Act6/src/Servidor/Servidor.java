package Servidor;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	private Socket socket = null;
	private ServerSocket ss = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	PrintWriter salidaAlCliente = null;
	private boolean fin = false;
	private Scanner sc;

	public Servidor(int puerto) {
		try {
			ss = new ServerSocket(puerto);
			System.out.println("Arrancando...");
			socket = ss.accept();
			System.out.println("Cliente " + socket + " Aceptado.");
			open();
			String texto = "";
			while (!fin) {
				try {
					String entrada = dis.readUTF();
					System.out.println(entrada);
					fin = entrada.equalsIgnoreCase("adios");
					System.out.println("Introduzca Mensaje: " );
					sc = new Scanner(System.in);
					salidaAlCliente = new PrintWriter(socket.getOutputStream(), true);
					salidaAlCliente.println(sc.next());


				} catch (IOException ioe) {
					fin = true;
				}
			}
			close();

		} catch (IOException ioe) {
			fin = true;
		}
	}

	private void close() throws IOException {
		if (socket != null)
			socket.close();
		if (dis != null)
			dis.close();

	}

	private void open() throws IOException {
		dis = new DataInputStream(new BufferedInputStream(
				socket.getInputStream()));
		dos = new DataOutputStream(socket.getOutputStream());

	}

	public static void main(String args[]) {
		Servidor server = new Servidor(Integer.parseInt("8080"));
	}

}
