package Servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Banco.Tarjeta;

public class Servidor {

	public static void main(String[] args) {
		try {
			ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
			rellenoArrayList(tarjetas);

			ServerSocket ss = new ServerSocket(5000);
			System.out.println("Arrancando el Servidor");

			Socket s = ss.accept();
			System.out.println("Nuevo Cliente");

			// Inicializar entrada y salida
			BufferedReader mensajedelCliente = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			PrintWriter salidaalCliente = new PrintWriter(s.getOutputStream(),
					true);
			int numero; // Lo
						// Primero
						// que
						// espera
						// el
						// servidor
						// es
						// la
						// opcion
			do {
				numero = Integer.parseInt(mensajedelCliente.readLine());
				if (numero == 1 || numero == 2) {
					int cuenta = Integer.parseInt(mensajedelCliente.readLine()); // Lo
																					// segundo
																					// que
																					// espera
																					// el
																					// servidor
																					// es
																					// el
																					// Numero
																					// de
																					// Cuenta
					Tarjeta tarjeta = buscarTarjeta(tarjetas, cuenta);
					if (tarjeta != null) {
						if (numero == 1) {
							sacarDinero(cuenta, tarjetas, mensajedelCliente,
									salidaalCliente);
						} else if (numero == 2) {
							infresarDinero(cuenta, tarjetas, mensajedelCliente,
									salidaalCliente);
						}
					} else
						salidaalCliente.println("La Cuenta No Existe");

				} else if (numero == 0) {
					salidaalCliente.println("Adios");
				} else
					salidaalCliente.println("Numero Incorrecto");

			} while (numero != 0);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * MŽtodo para rellenar el Array de Tarjetas
	 * 
	 * @param tarjetas
	 */
	private static void rellenoArrayList(ArrayList<Tarjeta> tarjetas) {
		tarjetas.add(new Tarjeta(11111111, 2222, 3000));
		tarjetas.add(new Tarjeta(22222222, 3333, 4000));
		tarjetas.add(new Tarjeta(33333333, 4444, 5000));
		tarjetas.add(new Tarjeta(44444444, 5555, 6000));
		System.out.println(tarjetas.toString());

	}

	/**
	 * MŽtodo para ingresar Dinero
	 * 
	 * @param cuenta
	 * @param tarjetas
	 * @param mensajedelCliente
	 * @param salidaalCliente
	 */
	private static void infresarDinero(int cuenta, ArrayList<Tarjeta> tarjetas,
			BufferedReader mensajedelCliente, PrintWriter salidaalCliente) {
		try {
			salidaalCliente.println("Dinero a Ingresar");
			double dinero = Double.parseDouble(mensajedelCliente.readLine()); // Si
																				// Ingreso
																				// dinero
																				// lo
																				// siguiente
																				// que
																				// espera
																				// es
																				// la
																				// cantidad
			Tarjeta tarjeta = buscarTarjeta(tarjetas, cuenta);
			tarjeta.setSaldo(tarjeta.getSaldo() + dinero);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * MŽtodo para Sacar Dinero
	 * 
	 * @param cuenta
	 * @param tarjetas
	 * @param mensajedelCliente
	 * @param salidaalCliente
	 */
	private static void sacarDinero(int cuenta, ArrayList<Tarjeta> tarjetas,
			BufferedReader mensajedelCliente, PrintWriter salidaalCliente) {
		try {

			salidaalCliente.println("Introduzca PIN");
			int pin = Integer.parseInt(mensajedelCliente.readLine()); // Si saco
																		// Dinero
																		// el
																		// servidor
																		// espera
																		// el
																		// PIN

			salidaalCliente.println("Cuanto dinero quiere Sacar");
			double dinero = Double.parseDouble(mensajedelCliente.readLine()); // Y
																				// luego
																				// el
																				// dinero
																				// a
																				// sacar

			Tarjeta aux = comprobarDatos(tarjetas, cuenta, pin, dinero);
			aux.setSaldo(aux.getSaldo() - dinero);

		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * MŽtodo para buscar una tarjeta
	 * 
	 * @param tarjetas
	 * @param id
	 * @return
	 */
	private static Tarjeta buscarTarjeta(ArrayList<Tarjeta> tarjetas, int id) {
		for (int i = 0; i < tarjetas.size(); i++) {
			Tarjeta aux = tarjetas.get(i);
			if (aux.getNumero() == id) {
				return aux;
			}
		}
		return null;
	}

	/**
	 * MŽtodo para comprobar los datos de la tarjeta
	 * 
	 * @param tarjetas
	 * @param cuenta
	 * @param clave
	 * @param dinero
	 * @return
	 */
	private static Tarjeta comprobarDatos(ArrayList<Tarjeta> tarjetas,
			int cuenta, int clave, double dinero) {
		for (int i = 0; i < tarjetas.size(); i++) {
			Tarjeta aux = tarjetas.get(i);
			if (aux.getNumero() == cuenta && aux.getClave() == clave
					&& aux.getSaldo() >= dinero) {
				return aux;
			}
		}
		return null;
	}

}
