package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Clase.Alumno;
import Clase.Nota;

public class Servidor2 extends Thread {
	Socket s1 = null;
	ArrayList<Alumno> alumnos = null;

	public Servidor2(Socket s1, ArrayList alumnos) {
		this.s1 = s1;
		this.alumnos = alumnos;
	}

	public void run() {
		rellenarAlumnos();
		try {
			System.out.println("Conectado... ");

			BufferedReader entrada = new BufferedReader(new InputStreamReader(
					s1.getInputStream()));
			PrintWriter salida = new PrintWriter(s1.getOutputStream(), true);

			String nombre = entrada.readLine();
			Alumno alumno = buscarUsuario(nombre);

			if (alumno != null) {
				System.out.println("..." + nombre);
			}
			boolean salir = false;
			int opc = 0;
			while (!salir) {
				// recibimos la peticion
				String aux = entrada.readLine();
				String peticion[] = aux.split("/");
				System.out.println("Usuario " + alumno.getNombre()
						+ " peticion " + peticion[0].toString());
				// System.out.println(peticion.toString());
				// System.out.println(peticion[0].toString());

				opc = Integer.parseInt(peticion[0]);
				String respuesta = null;

				switch (opc) {
				case (1):
					respuesta = alumno.listar();
					break;
				case (2):
					String s = "";
                Alumno alumno2= this.buscarUsuario(nombre);
                if (alumno2 == null) {
                    respuesta = "No se encuentra el destinatario";
                } else {
                	System.out.println(aux);
                	int nota = Integer.parseInt(peticion[1]);
                	
                    respuesta = alumno2.anadir(new Nota(nombre, nota));
                }
					break;
				case (3):

					break;
				case (0):
					salir = true;
					respuesta = "Adios";
					break;
				default:
					respuesta = "Entrada al servidor no reconocida";
					System.out.println(respuesta);
				}

				salida.println(respuesta);
				System.out.println("Usuario " + alumno.getNombre()
						+ " respuesta " + respuesta);

			}

			// fin
			System.out.println("Usuario " + alumno.getNombre()
					+ " desconectado");
			entrada.close();
			salida.close();
			s1.close();

		} catch (IOException ex) {
			Logger.getLogger(Servidor2.class.getName()).log(Level.SEVERE, null,
					ex);
		}

	}

	private void rellenarAlumnos() {
		alumnos.add(new Alumno("Juan"));
		alumnos.add(new Alumno("Carlos"));
		alumnos.add(new Alumno("David"));
		alumnos.add(new Alumno("Katy"));

	}

	private Alumno buscarUsuario(String nombre) {

		Alumno alumno = null;
		boolean encontrado = false;
		for (int i = 0; i < this.alumnos.size() && !encontrado; i++) {
			if (alumnos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				alumno = alumnos.get(i);
				encontrado = true;
			}

		}
		return alumno;
	}

}
