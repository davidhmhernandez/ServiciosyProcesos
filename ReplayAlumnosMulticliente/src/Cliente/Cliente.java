package Cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		try{
			Socket s = new Socket("localhost",5000);
			Scanner sc = new Scanner(System.in);
			
			PrintWriter mensajealServidor = new PrintWriter(
					s.getOutputStream(), true);
			BufferedReader mensajedelServidor = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			
			System.out.println(mensajedelServidor.readLine());//(1)Esperamos Mensaje
			String nombre = sc.next();
			mensajealServidor.println(nombre);//(1) Mandamos el Nombre
			
			int opcion;
			do{
				System.out.println("Introduzca Numero");
				System.out.println("1-Ver Notas");
				System.out.println("2-A–adir Nota");
				System.out.println("3-Ver Media");
				System.out.println("0-Salir");
				opcion = sc.nextInt();
				mensajealServidor.println(opcion);//(2)Mandamos la Opcion
				
				if(opcion==1){
					System.out.println(mensajedelServidor.readLine());//(2)Esperamos las notas
				}else if(opcion==2){
					System.out.println(mensajedelServidor.readLine());//(3)Esperamos mensaje del Servidor
					int nota = sc.nextInt();
					mensajealServidor.println(nota);//(3)Mandamos la Nota
					System.out.println(mensajedelServidor.readLine());//(4)Esperamos mensaje del Servidor
				}else if(opcion==3){
					System.out.println(mensajedelServidor.readLine());//(5)Esperamos mensaje del Servidor
				}
				
			}while(opcion!=0);
			System.out.println(mensajedelServidor.readLine());//(6)Esperamos mensaje del Servidor
		}catch(Exception e){
			e.getMessage();
		}
	}

}
