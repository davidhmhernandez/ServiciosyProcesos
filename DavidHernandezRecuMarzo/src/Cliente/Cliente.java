package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {
		Socket s = new Socket("localhost", 5000);
		Scanner sc = new Scanner(System.in);

		// inicailizamos antes del bucle

		PrintWriter salidaAlServidor = new PrintWriter(s.getOutputStream(),
				true);
		BufferedReader entradaDesdeElServidor = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		int numeroN;
		
		
		
	}

}
