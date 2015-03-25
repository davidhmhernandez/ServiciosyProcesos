package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {
		Socket s = new Socket("localhost", 9000);
		Scanner sc = new Scanner(System.in);

		// inicailizamos antes del bucle

		PrintWriter salidaAlServidor = new PrintWriter(s.getOutputStream(),
				true);
		BufferedReader entradaDesdeElServidor = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		int numeroN;

		String mensajeServidor = null;
		System.out.println("Introduzca Nombre");
		String nombre = sc.next();
		salidaAlServidor.println(nombre);
		mensajeServidor = entradaDesdeElServidor.readLine();
		System.out.println(mensajeServidor);
		do {

			System.out.println("Introduzca Numero");
			System.out.println("1--Ver Lista de Mensajes");
			System.out.println("2--Mostrar Mensaje");
			System.out.println("3--Borrar Mensaje");
			System.out.println("4--Enviar Mensaje");
			System.out.println("0--SALIR");
			String numero = sc.next();
			numeroN = Integer.parseInt(numero);
			// habilitamos la salida al servidor
			salidaAlServidor.println(numero);

			if (numeroN == 1) {
				misMensajes(sc, salidaAlServidor, entradaDesdeElServidor);
			} else if (numeroN == 2) {
				mostrarMensaje(sc, salidaAlServidor, entradaDesdeElServidor);
			} else if (numeroN == 3) {
				borrarMensaje(sc, salidaAlServidor, entradaDesdeElServidor);
			} else if (numeroN == 4) {
				enviarMensaje(nombre, sc, salidaAlServidor,
						entradaDesdeElServidor);
			}

		} while (numeroN != 0);

		// cierro todo
		salidaAlServidor.close();
		entradaDesdeElServidor.close();
		s.close();
		System.out.println("Cliente Desconectado");
	}

	private static void borrarMensaje(Scanner sc, PrintWriter salidaAlServidor,
			BufferedReader entradaDesdeElServidor) throws IOException {
		String mensajeServidor;
		System.out.println("Introduzca Numero de Mensaje");
		String mensaje = sc.next();
		salidaAlServidor.println(mensaje);
		mensajeServidor = entradaDesdeElServidor.readLine();
		System.out.println("Mensaje: " + mensajeServidor);

	}

	private static void misMensajes(Scanner sc, PrintWriter salidaAlServidor,
			BufferedReader entradaDesdeElServidor) throws IOException {
		String mensajeServidor;
		System.out.println("Introduzca Nombre");
		String mensaje = sc.next();
		salidaAlServidor.println(mensaje);
		mensajeServidor = entradaDesdeElServidor.readLine();
		System.out.println("Mensajes: " + mensajeServidor);

	}

	private static void mostrarMensaje(Scanner sc,
			PrintWriter salidaAlServidor, BufferedReader entradaDesdeElServidor)
			throws IOException {
		String mensajeServidor;
		System.out.println("Introduzca Numero de Mensaje");
		String mensaje = sc.next();
		salidaAlServidor.println(mensaje);
		mensajeServidor = entradaDesdeElServidor.readLine();
		System.out.println("Mensaje: " + mensajeServidor);
	}

	private static void enviarMensaje(String nombre, Scanner sc,
			PrintWriter salidaAlServidor, BufferedReader entradaDesdeElServidor)
			throws IOException {
		String mensajeServidor;
		salidaAlServidor.println(nombre);
		System.out.println("Introduzca Destinatario");
		String mensaje = sc.next();
		salidaAlServidor.println(mensaje);
		mensajeServidor = entradaDesdeElServidor.readLine();
		System.out.println(mensajeServidor);
		if (mensajeServidor.equalsIgnoreCase("Introduzca el Asunto")) {
			mensaje = sc.next();
			salidaAlServidor.println(mensaje);
			mensajeServidor = entradaDesdeElServidor.readLine();
			System.out.println(mensajeServidor);
			if (mensajeServidor.equalsIgnoreCase("Introduzca el Mensaje")) {
				mensaje = sc.next();
				salidaAlServidor.println(mensaje);
				mensajeServidor = entradaDesdeElServidor.readLine();
				System.out.println(mensajeServidor);
			}
		}
	}

}