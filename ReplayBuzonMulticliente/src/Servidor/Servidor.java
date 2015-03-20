package Servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Buzon.Buzon;
import Buzon.Mensaje;

public class Servidor extends Thread {
	private ServerSocket ss;
	private Socket s;
	private ArrayList<Buzon>buzones;
	
	public Servidor(ServerSocket ss, Socket s, ArrayList<Buzon>buzones) {
		this.ss=ss;
		this.s=s;
		this.buzones=buzones;
	}
	
	@Override
	public void run() {
		try{
			BufferedReader mensajedelCliente = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			PrintWriter salidaalCliente = new PrintWriter(s.getOutputStream(),
					true);
			
			salidaalCliente.println("Introduzca Nombre");// (1) Enviamos el Nombre
			String nombre = mensajedelCliente.readLine();// (1) Esperamos a Recibir el Nombre
			Buzon buzon = addUsuarios(nombre, buzones);
			if(buzon==null){
				buzones.add(new Buzon(nombre));
			}
			
			int numero;
			do {
				numero = Integer.parseInt(mensajedelCliente.readLine()); //(2) Esperamos a Recibir la Opcion
				if (numero == 1 || numero == 2 || numero == 3 || numero == 4) {
					if (numero == 1) {
						verMisMensajes(nombre, buzones, salidaalCliente);
					} else if (numero == 2) {
						verMensaje(nombre, buzones, mensajedelCliente, salidaalCliente);
					} else if (numero == 3) {
						borrarMensaje(nombre, buzones, mensajedelCliente,
								salidaalCliente);
					} else if (numero == 4) {
						enviarMensaje(nombre,buzones, mensajedelCliente,
								salidaalCliente);
					} else if (numero == 0) {
						salidaalCliente.println("Adios");
					}	
				}else salidaalCliente.println("Numero Incorrecto");
			}while(numero!=0);
			
		}catch(Exception e){
			e.getMessage();
		}
	}

	private void enviarMensaje(String nombre, ArrayList<Buzon> buzones2,
			BufferedReader mensajedelCliente, PrintWriter salidaalCliente) {
		try {
			salidaalCliente.println("Introduzca Asunto"); //Enviamos asunto al Cliente
			String asunto=mensajedelCliente.readLine(); //Esperamos el asunto del Cliente
			
			salidaalCliente.println("Introduzca Mensaje"); //Enviamos mensaje al Cliente
			String mensaje=mensajedelCliente.readLine(); //Esperamos el mensaje del Cliente
			
			salidaalCliente.println("Introduzca Autor"); //Enviamos autor al Cliente
			String autor=mensajedelCliente.readLine(); //Esperamos el autor del Cliente
			
			
			Buzon buzon = addUsuarios(nombre, buzones);
			if (buzon != null) {
				String respuesta = buzon.add(new Mensaje(asunto,mensaje,autor));
				salidaalCliente.println(respuesta); //Eviamos la Respuesta al Cliente
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	private void borrarMensaje(String nombre, ArrayList<Buzon> buzones2,
			BufferedReader mensajedelCliente, PrintWriter salidaalCliente) {
		try {
			salidaalCliente.println("Introduzca Numero"); //Enviamos Numero al Cliente
			int numero = Integer.parseInt(mensajedelCliente.readLine()); //Esperamos el numero del Cliente
			Buzon buzon = addUsuarios(nombre, buzones);
			if (buzon != null) {
				String mensaje = buzon.borrar(numero);
				salidaalCliente.println(mensaje);// Enviamos los Mensajes al
													// Cliente
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	private void verMensaje(String nombre, ArrayList<Buzon> buzones2,
			BufferedReader mensajedelCliente, PrintWriter salidaalCliente) {
		try {
			salidaalCliente.println("Introduzca Numero"); //Enviamos Numero al Cliente
			int numero = Integer.parseInt(mensajedelCliente.readLine()); //Esperamos el numero del Cliente
			Buzon buzon = addUsuarios(nombre, buzones);
			if (buzon != null) {
				String mensaje = buzon.mostrar(numero);
				salidaalCliente.println(mensaje);// Enviamos los Mensajes al
													// Cliente
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	private void verMisMensajes(String nombre, ArrayList<Buzon> buzones2,
			PrintWriter salidaalCliente) {
		Buzon buzon = addUsuarios(nombre, buzones);
		if (buzon != null) {
			String mensajes = buzon.listar();
			salidaalCliente.println(mensajes);// Enviamos los Mensajes al
												// Cliente
		}
		
	}

	private Buzon addUsuarios(String nombre, ArrayList<Buzon> buzones2) {
		for (int i = 0; i < buzones.size(); i++) {
			Buzon buzon = buzones.get(i);
			if (buzon.getNombreUsuario().equalsIgnoreCase(nombre))
				;
			{
				return buzon;
			}
		}
		return null;
	}

}
