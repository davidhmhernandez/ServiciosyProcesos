package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		try {
			// conexión al servidor
			Socket s = new Socket("localhost", 5000);
			System.out.println("Conectado");

			// habilitamos la entrada desde el servidor
			BufferedReader entradaDesdeElServidor = new BufferedReader(
					new InputStreamReader(s.getInputStream()));

			String texto = entradaDesdeElServidor.readLine();
			while (texto != null) {
				System.out.println("El servidor dice " + texto);
				texto = entradaDesdeElServidor.readLine();
			}

			// cierro todo
			entradaDesdeElServidor.close();
			s.close();
			System.out.println("Desconectado");

		} catch (UnknownHostException ex) {
			System.out.println("Servidor no encontrado");
		} catch (IOException ex) {
			System.out.println("Error");
		}

	}

}
