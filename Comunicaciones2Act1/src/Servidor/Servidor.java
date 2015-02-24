package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Servidor extends Thread {
	private ServerSocket ss;
	private Socket s;
	Semaphore semaforo = null;
	

	public Servidor(ServerSocket ss, Socket s, Semaphore sem) {
		this.s = s;
		this.ss = ss;
		this.semaforo = sem;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String palabra = getCadenaAlfanumAleatoria (4);
		System.out.println(palabra);
		PrintWriter salidaAlCliente = null;
		 String palabraRecibida;
		
		
		
		try {
			// inicializamos la salida y entrada del cliente
			BufferedReader entradaDesdeElCliente = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			 salidaAlCliente = new PrintWriter(s.getOutputStream(),
					true);
			 do{
			 salidaAlCliente.println("Introduzca Palabra");
			 palabraRecibida=entradaDesdeElCliente.readLine();
			 }while(!palabraRecibida.equalsIgnoreCase(palabra));
			 
			
			if(palabraRecibida.equalsIgnoreCase(palabra)){
				 salidaAlCliente.println("Acierto"); 
				 semaforo.release();
			 }
			 

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			salidaAlCliente.println("Error Irrecuperable");
			semaforo.release();
		}
	}
	
	/**
	 * Metodo que genera una palabra aleatoria
	 * @param longitud
	 * @return
	 */
	String getCadenaAlfanumAleatoria (int longitud){
		String cadenaAleatoria = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while ( i < longitud){
		char c = (char)r.nextInt(255);
		if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
		cadenaAleatoria += c;
		i++;
		}
		}
		return cadenaAleatoria;
		}
}
