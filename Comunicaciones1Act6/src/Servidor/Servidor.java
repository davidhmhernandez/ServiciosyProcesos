package Servidor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Banco.Tarjeta;

public class Servidor {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		rellenoArrayList(tarjetas);

		ServerSocket ss = new ServerSocket(5000);
		System.out.println("Arrancado");
		Socket s = ss.accept();
		System.out.println("Nuevo Cliente");

		// inicializamos la salida y entrada del cliente
		BufferedReader entradaDesdeElCliente = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		PrintWriter salidaAlCliente = new PrintWriter(s.getOutputStream(), true);
		int numero;
		do {
			// habilitamos la entrada desde el cliente
			String mensaje = entradaDesdeElCliente.readLine();
			System.out.println("El Cliente dice: " + mensaje);
			numero = Integer.parseInt(mensaje);
			if (numero == 1 || numero == 2) {
				if (numero == 1) {
					sacarDinero(tarjetas, entradaDesdeElCliente,
							salidaAlCliente);

				} else if (numero == 2) {
					ingresarDinero(tarjetas, entradaDesdeElCliente,
							salidaAlCliente);
				}
			} else if (numero == 0) {
				salidaAlCliente.println("Adios");
			} else {
				salidaAlCliente.println("Número Incorrecto");
			}

		} while (numero != 0);

	}

	private static void rellenoArrayList(ArrayList<Tarjeta> tarjetas) {
		Tarjeta tarjeta = new Tarjeta(11111111, 2222, 1000);
		tarjetas.add(tarjeta);

		Tarjeta tarjeta2 = new Tarjeta(22222222, 3333, 7000);
		tarjetas.add(tarjeta2);

		Tarjeta tarjeta3 = new Tarjeta(33333333, 4444, 5000);
		tarjetas.add(tarjeta3);

		Tarjeta tarjeta4 = new Tarjeta(44444444, 5555, 10000);
		tarjetas.add(tarjeta4);
	}

	private static void ingresarDinero(ArrayList<Tarjeta> tarjetas,
			BufferedReader entradaDesdeElCliente, PrintWriter salidaAlCliente)
			throws IOException {
		String mensaje;
		mensaje = entradaDesdeElCliente.readLine();
		int cuenta = Integer.parseInt(mensaje);
		System.out.println("El Cliente quiere Ingresar en la cuenta: "
				+ mensaje);
		for (Tarjeta tarjetas1 : tarjetas) {
			if (cuenta == tarjetas1.getNumero()) {
				salidaAlCliente.println("¿Cuanto Dinero Quiere Ingresar?");
				mensaje = entradaDesdeElCliente.readLine();
				double ingreso = Double.parseDouble(mensaje);
				tarjetas1.setSaldo(tarjetas1.getSaldo()+ingreso);
				salidaAlCliente.println("Operación Realizada "+tarjetas1);
			}
		}
	}

	private static void sacarDinero(ArrayList<Tarjeta> tarjetas,
			BufferedReader entradaDesdeElCliente, PrintWriter salidaAlCliente)
			throws IOException {
		String mensaje;
		mensaje = entradaDesdeElCliente.readLine();
		int cuenta = Integer.parseInt(mensaje);
		System.out.println("El Cliente quiere sacar de la cuenta: "
				+ mensaje);
		for (Tarjeta tarjetas1 : tarjetas) {

			if (cuenta == tarjetas1.getNumero()) {
				salidaAlCliente.println("Introduzca PIN");
				mensaje = entradaDesdeElCliente.readLine();
				int pin = Integer.parseInt(mensaje);
				if (pin == tarjetas1.getClave()) {
					salidaAlCliente
							.println("PIN Correcto --- ¿Cuanto Dinero Quiere Sacar?");
					mensaje = entradaDesdeElCliente.readLine();
					double dinero = Double.parseDouble(mensaje);
					if (tarjetas1.getSaldo() > dinero) {
						tarjetas1.setSaldo(tarjetas1.getSaldo()
								- dinero);
						
						salidaAlCliente.println("Operación Realizada "+tarjetas1);

					}//else salidaAlCliente.println("NO hay Suficiente Saldo");
				}//else salidaAlCliente.println("PIN Incorrecto");
			}//else salidaAlCliente.println("NO Existe el Numero de Tarjeta");

		}
	}

}
