package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost", 5000);

		Scanner sc = new Scanner(System.in);

		// inicailizamos antes del bucle

		PrintWriter salidaAlServidor = new PrintWriter(s.getOutputStream(),
				true);
		BufferedReader entradaDesdeElServidor = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		int numeroN;
		
		String mensajeServidor = null;
		do {

			System.out.println("Introduzca Numero");
			System.out.println("1--Sacar Dinero");
			System.out.println("2--Ingresar Dinero");
			System.out.println("0--SALIR");
			String numero = sc.next();
			numeroN = Integer.parseInt(numero);
			// habilitamos la salida al servidor
			salidaAlServidor.println(numero);
			
			if (numeroN == 1 ) {
				sacarDinero(sc, salidaAlServidor, entradaDesdeElServidor);
			}
			else if(numeroN ==2){
				ingresarDinero(sc, salidaAlServidor, entradaDesdeElServidor);
			}
			
			

			

		} while (numeroN != 0);

		// cierro todo
		salidaAlServidor.close();
		entradaDesdeElServidor.close();
		s.close();
		System.out.println("Cliente Desconectado");

	}

	private static void ingresarDinero(Scanner sc,
			PrintWriter salidaAlServidor, BufferedReader entradaDesdeElServidor)
			throws IOException {
		String mensajeServidor;
		System.out.println("Introduzca Cuenta");
		String cuenta = sc.next();
		salidaAlServidor.println(cuenta);
		mensajeServidor = entradaDesdeElServidor.readLine();
		System.out.println("El Servidor Dice: " + mensajeServidor);
		if(mensajeServidor.equalsIgnoreCase("¿Cuanto Dinero Quiere Ingresar?")){
			String ingreso = sc.next();
			salidaAlServidor.println(ingreso);
		}
		mensajeServidor = entradaDesdeElServidor.readLine();
		System.out.println("El Servidor Dice: " + mensajeServidor);
	}

	private static void sacarDinero(Scanner sc, PrintWriter salidaAlServidor,
			BufferedReader entradaDesdeElServidor) throws IOException {
		String mensajeServidor;
		System.out.println("Introduzca Cuenta");
		String cuenta = sc.next();
		salidaAlServidor.println(cuenta);
		mensajeServidor = entradaDesdeElServidor.readLine();
		System.out.println("El Servidor Dice: " + mensajeServidor);
		if(mensajeServidor.equalsIgnoreCase("Introduzca PIN")){
			String pin = sc.next();
			salidaAlServidor.println(pin);
		}
		mensajeServidor = entradaDesdeElServidor.readLine();
		System.out.println("El Servidor Dice: " + mensajeServidor);
		if(mensajeServidor.equalsIgnoreCase("PIN Correcto --- ¿Cuanto Dinero Quiere Sacar?")){
			String dinero = sc.next();
			salidaAlServidor.println(dinero);
			
		}
		mensajeServidor = entradaDesdeElServidor.readLine();
		System.out.println("El Servidor Dice: " + mensajeServidor);
	}

}
