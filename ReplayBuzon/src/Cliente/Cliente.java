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
			
			System.out.println(mensajedelServidor.readLine());
			String nombre = sc.next();
			mensajealServidor.println(nombre);
			
			int opcion;
			do{
				System.out.println("Introduzca Numero");
				System.out.println("1-Ver Lista de Mensajes");
				System.out.println("2-Mostar Mensaje");
				System.out.println("3-Borrar Mensaje");
				System.out.println("4-Enviar Mensaje");
				System.out.println("0-Salir");
				opcion = sc.nextInt();
				mensajealServidor.println(opcion);
				
				if(opcion == 1){
					System.out.println(mensajedelServidor.readLine());
				}else if(opcion==2){
					System.out.println(mensajedelServidor.readLine());
					int numero = sc.nextInt();
					mensajealServidor.println(numero);
					System.out.println(mensajedelServidor.readLine());
				}else if(opcion==3){
					System.out.println(mensajedelServidor.readLine());
					int numero = sc.nextInt();
					mensajealServidor.println(numero);
					System.out.println(mensajedelServidor.readLine());
				}else if(opcion==4){
					System.out.println(mensajedelServidor.readLine());
					String asunto = sc.next();
					mensajealServidor.println(asunto);
					System.out.println(mensajedelServidor.readLine());
					String mensaje = sc.next();
					mensajealServidor.println(mensaje);
					System.out.println(mensajedelServidor.readLine());
					String autor = sc.next();
					mensajealServidor.println(autor);
					System.out.println(mensajedelServidor.readLine());
				}
				
			}while(opcion!=0);
			System.out.println(mensajedelServidor.readLine());
			
		}catch(Exception e){
			e.getMessage();
		}

	}

}
