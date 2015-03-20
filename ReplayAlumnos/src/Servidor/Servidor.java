package Servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Clase.Alumno;
import Clase.Nota;

public class Servidor {

	public static void main(String[] args) {
		try{
			
			ServerSocket ss = new ServerSocket(5000);
			System.out.println("Arrancando el Servidor");

			Socket s = ss.accept();
			System.out.println("Nuevo Cliente");

			// Inicializar entrada y salida
			BufferedReader mensajedelCliente = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			PrintWriter salidaalCliente = new PrintWriter(s.getOutputStream(),
					true);
			
			ArrayList<Alumno>alumnos = new ArrayList<Alumno>();
			rellenarArrayList(alumnos);
			
			salidaalCliente.println("Introduzca Nombre"); //(1)Enviamos nombre
			String nombre = mensajedelCliente.readLine(); //(1)Esperamos nombre
			
			Alumno alumno = buscarAlumno(nombre,alumnos);
			if(alumno!=null){
				int numero;
				do{
					numero=Integer.parseInt(mensajedelCliente.readLine()); //(2)Esperamos opcion
					if(numero==1 || numero==2 || numero==3){
						if(numero==1){
							verNotas(nombre,alumnos,salidaalCliente);
						}else if(numero==2){
							addNota(nombre,alumnos, mensajedelCliente,salidaalCliente);
						}else if(numero==3){
							verMedia(nombre,alumnos, mensajedelCliente,salidaalCliente);
						}
						
					}else if(numero==0){
						salidaalCliente.println("Adios");//(6)Enviamos Adios
					}
					
				}while(numero!=0);
			}else salidaalCliente.println("El Alumno No Existe");//(6)Enviamos Alumno no Exite
			
		}catch(Exception e){
			e.getMessage();
		}
	}

	private static void rellenarArrayList(ArrayList<Alumno> alumnos) {
		alumnos.add(new Alumno("Juan"));
		alumnos.add(new Alumno("Carlos"));
		alumnos.add(new Alumno("David"));
		alumnos.add(new Alumno("Katy"));
		
	}

	private static void verMedia(String nombre, ArrayList<Alumno> alumnos,
			BufferedReader mensajedelCliente, PrintWriter salidaalCliente) {
		Alumno alumno = buscarAlumno(nombre, alumnos);
		if(alumno!=null){
			String media = alumno.verMedia();
			salidaalCliente.println(media);//(5)Enviamos Media
		}
		
	}

	private static void addNota(String nombre, ArrayList<Alumno> alumnos,
			BufferedReader mensajedelCliente, PrintWriter salidaalCliente) {
		try{
			salidaalCliente.println("Introduzca Nota");//(3)Enviamos Nota
			int nota = Integer.parseInt(mensajedelCliente.readLine());//(3)Esperamos Nota
			Alumno alumno = buscarAlumno(nombre, alumnos);
			if(alumno!=null){
				String respuesta = alumno.addNota(new Nota(nota));
				salidaalCliente.println(respuesta);//(4)Enviamos Mensaje 
			}
			
			
		}catch(Exception e){
			e.getMessage();
		}
		
	}

	private static void verNotas(String nombre, ArrayList<Alumno> alumnos,
			PrintWriter salidaalCliente) {
		Alumno alumno = buscarAlumno(nombre, alumnos);
		if(alumno!=null){
			String notas = alumno.verNotas();
			salidaalCliente.println(notas);//(2)Enviamos Notas
		}
		
	}

	private static Alumno buscarAlumno(String nombre, ArrayList<Alumno> alumnos) {
		for (int i = 0; i < alumnos.size(); i++) {
			Alumno alumno = alumnos.get(i);
			if (alumno.getNombre().equalsIgnoreCase(nombre))
			{
				return alumno;
			}
		}
		return null;
	}

}
