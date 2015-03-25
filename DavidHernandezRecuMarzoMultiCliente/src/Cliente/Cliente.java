package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
	public static void main(String args[]) {
		try {
			// conexion
			Socket s1 = new Socket("localhost", 5000);
			System.out.println("Conectado");

			// preapramos la entrada y la salida
			PrintWriter salida = new PrintWriter(s1.getOutputStream(), true);
			BufferedReader respuesta = new BufferedReader(
					new InputStreamReader(s1.getInputStream()));

			System.out.println("Introduzca nonmbre de usuario");
			Scanner sc = new Scanner(System.in);
			String nombre = sc.next();
			salida.println(nombre);

			// menu
			int opc = 0;
			do {
				System.out.println("¿Que operacion desea?");
				System.out.println("1--Ver Notas");
				System.out.println("2--Añadir Nota");
				System.out.println("3--Ver Media");
				System.out.println("0--SALIR");

				String parametros = sc.next();
				opc = Integer.parseInt(parametros);
				salida.println(parametros);

				switch (opc) {
				case (1):				
					break;
				case (2):
					System.out.println("Introduzca Nota");
					parametros = "/" + sc.next();
					break;
				case (3):
					
					break;
				}

				salida.println(parametros);

				// recibimos respuesta
				System.out.println(respuesta.readLine());

			} while (opc != 0);

			// cierro todo
			salida.close();
			respuesta.close();
			s1.close();

		} catch (UnknownHostException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null,
					ex);
			System.out.println("Servidor no encontrado");
		} catch (IOException ex) {
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null,
					ex);
			System.out.println("Error");
		}

	}

}
