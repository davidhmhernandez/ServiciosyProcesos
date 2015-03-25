package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	private static int id = 1;

	public static void main(String[] args) throws IOException {

		ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
		ArrayList<String> nombres = new ArrayList();
		nombres.add("Pepe");
		nombres.add("Maria");
		System.out.println(nombres.toString());
		añadirMensajes(mensajes);
		ServerSocket ss = new ServerSocket(5000);
		System.out.println("Arrancado");
		Socket s = ss.accept();
		System.out.println("Nuevo Cliente");

		// inicializamos la salida y entrada del cliente
		BufferedReader entradaDesdeElCliente = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		PrintWriter salidaAlCliente = new PrintWriter(s.getOutputStream(), true);
		int numero;
		String nombre;
		String mensaje = entradaDesdeElCliente.readLine();
		System.out.println("Soy: " + mensaje);
		nombre = mensaje;
		boolean encontrado = false;
		for (int i = 0; i < nombres.size(); i++) {
			if (nombres.get(i).equalsIgnoreCase(nombre)) {
				encontrado = true;
				salidaAlCliente.println("Hola " + nombre);
			}
		}
		if (!encontrado) {
			nombres.add(nombre);
			salidaAlCliente.println("Añadido " + nombre);
		}

		System.out.println(nombres.toString());
		do {
			// habilitamos la entrada desde el cliente
			mensaje = entradaDesdeElCliente.readLine();
			System.out.println(nombre + " dice: " + mensaje);
			numero = Integer.parseInt(mensaje);
			if (numero == 1 || numero == 2 || numero == 3 || numero == 4) {
				if (numero == 1) {
					misMensajes(nombre, mensajes, entradaDesdeElCliente,
							salidaAlCliente);
				} else if (numero == 2) {
					mostrarMensaje(nombre, mensajes, entradaDesdeElCliente,
							salidaAlCliente);
				} else if (numero == 3) {
					borrarMensaje(nombre, nombres, mensajes,
							entradaDesdeElCliente, salidaAlCliente);
				} else if (numero == 4) {
					enviarMensaje(nombres, mensajes, entradaDesdeElCliente,
							salidaAlCliente);
				}
			} else if (numero == 0) {
				salidaAlCliente.println("Adios");
			} else {
				salidaAlCliente.println("Número Incorrecto");
			}

		} while (numero != 0);
	}

	private static void borrarMensaje(String nombre, ArrayList<String> nombres,
			ArrayList<Mensaje> mensajes, BufferedReader entradaDesdeElCliente,
			PrintWriter salidaAlCliente) throws IOException {
		String mensaje;
		mensaje = entradaDesdeElCliente.readLine();
		int numero = Integer.parseInt(mensaje);
		System.out.println(nombre + " quiere borrar el Mesaje: " + mensaje);
		for (Mensaje mensaje2 : mensajes) {
			if (numero == mensaje2.getID()) {
				mensajes.remove(numero);
				salidaAlCliente.println("Mensaje Borrado");
			} else {
				salidaAlCliente.println("No Existe El Mensaje");
			}
		}

	}

	private static void misMensajes(String nombre, ArrayList<Mensaje> mensajes,
			BufferedReader entradaDesdeElCliente, PrintWriter salidaAlCliente)
			throws IOException {
		String mensaje;
		mensaje = entradaDesdeElCliente.readLine();
		System.out.println(nombre + " quiere leer sus Mensajes");
		for (Mensaje mensaje2 : mensajes) {
			if (mensaje2.getOrigen().equalsIgnoreCase(mensaje)) {

				salidaAlCliente.println(mensaje2.toString());
			} else {
				salidaAlCliente.println("No Existe El Cliente");
			}
		}

	}

	private static void añadirMensajes(ArrayList<Mensaje> mensajes) {

		Mensaje mensaje = new Mensaje(id, "Juan", "hola", "HOLA QUETAL");
		mensajes.add(mensaje);
		id++;
		Mensaje mensaje2 = new Mensaje(id, "Manolo", "adios",
				"ADIOS QUE VAYA BIEN");
		mensajes.add(mensaje2);
		id++;
		Mensaje mensaje3 = new Mensaje(id, "Maria", "quetal", "QUETAL ESTAS");
		mensajes.add(mensaje3);
		id++;
		Mensaje mensaje4 = new Mensaje(id, "David", "salir", "SALIR AHORA");
		mensajes.add(mensaje4);
		id++;

	}

	private static void mostrarMensaje(String nombre,
			ArrayList<Mensaje> mensajes, BufferedReader entradaDesdeElCliente,
			PrintWriter salidaAlCliente) throws IOException {
		String mensaje;
		mensaje = entradaDesdeElCliente.readLine();
		int numero = Integer.parseInt(mensaje);
		System.out.println(nombre + " quiere leer el Mesaje: " + mensaje);
		for (Mensaje mensaje2 : mensajes) {
			if (numero == mensaje2.getID()) {

				salidaAlCliente.println(mensaje2.toString());
			} else {
				salidaAlCliente.println("No Existe El Mensaje");
			}
		}

	}

	private static void enviarMensaje(ArrayList<String> nombres,
			ArrayList<Mensaje> mensajes, BufferedReader entradaDesdeElCliente,
			PrintWriter salidaAlCliente) throws IOException {
		String mensaje;
		mensaje = entradaDesdeElCliente.readLine();
		System.out.println(mensaje + " Envia Mensaje ");
		mensaje = entradaDesdeElCliente.readLine();
		String origen = mensaje;
		System.out.println("Para: " + mensaje);
		for (int i = 0; i < nombres.size(); i++) {
			if (nombres.get(i).equalsIgnoreCase(origen)) {

				salidaAlCliente.println("Introduzca el Asunto");
				mensaje = entradaDesdeElCliente.readLine();
				String asunto = mensaje;
				if (asunto != null) {
					salidaAlCliente.println("Introduzca el Mensaje");
					mensaje = entradaDesdeElCliente.readLine();
					String mensajeRe = mensaje;
					if (mensajeRe != null) {
						mensajes.add(new Mensaje(id, origen, asunto, mensajeRe));
						id++;
						salidaAlCliente.println("Mensaje Enviado");
						System.out.println(mensajes.toString());
					}
				}
			} else {
				salidaAlCliente.println("No Existe El Usuario");
			}
		}

	}
}
