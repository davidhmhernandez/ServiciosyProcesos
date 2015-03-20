package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 5000);
			Scanner sc = new Scanner(System.in);

			PrintWriter mensajealServidor = new PrintWriter(
					s.getOutputStream(), true);
			BufferedReader mensajedelServidor = new BufferedReader(
					new InputStreamReader(s.getInputStream()));

			int numeroN;

			do {
				System.out.println("Introduzca Numero");
				System.out.println("1-Sacar Dinero");
				System.out.println("2-Ingresar Dinero");
				System.out.println("0-Salir");
				numeroN = Integer.parseInt(sc.next());
				mensajealServidor.println(numeroN); // Lo Primero que envio es
													// la Opcion

				if (numeroN == 0) {

				} else {

					String numeroCuentaA = null;
					do {
						System.out.println("Introduzca Numero de Cuenta");
						numeroCuentaA = sc.next();
						int numeroCuenta = Integer.parseInt(numeroCuentaA);
						mensajealServidor.println(numeroCuenta); // Envio el
																	// Numero de
																	// Cuenta
					} while (numeroCuentaA.length() != 8);
					if (numeroN == 1) {
						sacarDinero(sc, mensajealServidor, mensajedelServidor);
					} else if (numeroN == 2) {
						ingresarDinero(sc, mensajealServidor,
								mensajedelServidor);
					}
				}

			} while (numeroN != 0);
			System.out.println(mensajedelServidor.readLine());

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void ingresarDinero(Scanner sc,
			PrintWriter mensajealServidor, BufferedReader mensajedelServidor) {
		try {
			System.out.println(mensajedelServidor.readLine()); // Al Ingresar
																// espero a que
																// el servidor
																// diga algo
			double dinero = sc.nextDouble();
			mensajealServidor.println(dinero); // Al ingresar envio el dinero
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void sacarDinero(Scanner sc, PrintWriter mensajealServidor,
			BufferedReader mensajedelServidor) {
		try {
			System.out.println(mensajedelServidor.readLine()); // Al Sacar
																// espero a que
																// el servidor
																// diga algo
			int pin = sc.nextInt();
			mensajealServidor.println(pin); // Al sacar envio el pin

			System.out.println(mensajedelServidor.readLine()); // Al Sacar
																// espero a que
																// el servidor
																// diga algo
			double dinero = sc.nextInt();
			mensajealServidor.println(dinero); // Al sacar envio el dinero
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
