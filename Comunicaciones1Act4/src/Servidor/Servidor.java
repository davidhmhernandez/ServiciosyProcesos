package Servidor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
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
			if (numero == 1 || numero == 2 || numero == 3 || numero == 4) {
				mensaje = entradaDesdeElCliente.readLine();
				System.out.println("El Cliente dice: " + mensaje);
				File f = new File(mensaje);
				if (numero == 1) {
					if (f.exists()) {
						if (f.isFile()) {
							salidaAlCliente.println("Es un Fichero Normal");
						} else if (f.isDirectory()) {
							salidaAlCliente.println("Es un Directorio");
						}
					} else if (!f.exists()) {
						salidaAlCliente.println("No Existe");
					}
				} else if (numero == 2) {
					if (f.exists()) {
						f.delete();
						salidaAlCliente.println("Borrado OK");
					} else if (!f.exists()) {
						salidaAlCliente.println("No Se Ha Borrado");
					}
				} else if (numero == 3) {
					if (f.exists()) {
						salidaAlCliente.println("No Se Ha Creado");
					} else if (!f.exists()) {
						f.createNewFile();
						salidaAlCliente.println("Creado OK");
					}
				} else if (numero == 4) {
					if(f.exists() && f.isDirectory()){
						String[] archivos = f.list();
						for (int i=0;i<archivos.length;i++){
							salidaAlCliente.println(archivos[i]);
						}
					}else if(!f.isDirectory()){
						salidaAlCliente.println("No es un Directorio");
					}else if(!f.exists()){
						salidaAlCliente.println("No Existe el Directorio");
					}
				}
			} else if (numero == 0) {
				salidaAlCliente.println("Adios");
			} else {
				salidaAlCliente.println("Número Incorrecto");
			}

		} while (numero != 0);

		// fin de la conexión
		entradaDesdeElCliente.close();
		salidaAlCliente.close();
		s.close();
		ss.close();
		System.out.println("Servidor Desconectado");

	}

}
