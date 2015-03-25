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
				System.out.println("1-Ver Articulos");
				System.out.println("2-Añadir Articulo");
				System.out.println("3-Borrar Articulo");
				System.out.println("0-Salir");
				opcion = sc.nextInt();
				mensajealServidor.println(opcion);//(2)Mandamos la Opcion
				
				if(opcion==1){
					System.out.println(mensajedelServidor.readLine());//(4)Esperamos Articulos
				}else if(opcion==2){
					System.out.println(mensajedelServidor.readLine());//(2)Esperamos Mensaje
					String articulo = sc.next();
					mensajealServidor.println(articulo);//(3) Mandamos articulo
					System.out.println(mensajedelServidor.readLine());///(3)Esperamos Respuesta
				}else if(opcion==3){
					System.out.println(mensajedelServidor.readLine());//(5)Esperamos Mensaje del servidor
					int numero = sc.nextInt();
					mensajealServidor.println(numero);//(4)Mandamos numero 
					System.out.println(mensajedelServidor.readLine());//(6)Esperamos Mensahe
				}
				
			}while(opcion!=0);
			System.out.println(mensajedelServidor.readLine());//(7)Esperamos Mensaje
		}catch(Exception e){
			e.getMessage();
		}

	}

}
