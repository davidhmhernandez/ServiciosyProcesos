package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Clase.Alumno;


public class Main {

	public static void main(String[] args) {
		ServerSocket ss;
		System.out.println("Arrancando el Servidor ");
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

		try {
			ss = new ServerSocket(5000);
			do {
				Socket s;
				s = ss.accept();
				Servidor server = new Servidor(ss, s, alumnos);
				server.start();

				// finalizar con una opcion
			} while (true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
