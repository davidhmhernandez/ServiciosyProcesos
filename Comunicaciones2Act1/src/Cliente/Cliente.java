package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	static Scanner sc;

	public static void main(String[] args) {
		Socket cliente = null;
		PrintWriter salida = null;
		BufferedReader entrada = null;
		boolean fin = false;
		try {
			cliente = new Socket("localhost", 5000);
			do {
				entrada = new BufferedReader(new InputStreamReader(
						cliente.getInputStream()));
				String finit = entrada.readLine();
				if(finit.equalsIgnoreCase("Acierto")||finit.equalsIgnoreCase("Error Irrecuperable")) {
					System.out.println(finit);
					fin = true;
				}else{
					System.out.println(finit);
					salida = new PrintWriter(cliente.getOutputStream(), true);
					
					
					sc = new Scanner(System.in);
					salida.println(sc.next());
				}
			} while (!fin);
			entrada.close();
			salida.close();
			cliente.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	


	}

}
