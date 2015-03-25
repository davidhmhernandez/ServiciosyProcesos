package Servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Supermercado.Articulo;
import Supermercado.Usuario;

public class Servidor extends Thread {
	private ServerSocket ss;
	private Socket s;
	private ArrayList<Usuario>usuarios;
	
	public Servidor(ServerSocket ss, Socket s, ArrayList<Usuario>usuarios) {
		this.ss=ss;
		this.s=s;
		this.usuarios=usuarios;
	}
	@Override
	public void run() {
		try{
			rellenarArray(usuarios);
			BufferedReader mensajedelCliente = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			PrintWriter salidaalCliente = new PrintWriter(s.getOutputStream(),
					true);
			salidaalCliente.println("Introduzca Nombre"); //(1)Enviamos nombre
			String nombre = mensajedelCliente.readLine(); //(1)Esperamos nombre
			Usuario usuario = buscarUsuario(nombre,usuarios);
			if(usuario!=null){
				int numero;
				do{
					numero=Integer.parseInt(mensajedelCliente.readLine()); //(2)Esperamos opcion
					if(numero==1 || numero==2 || numero==3){
						if(numero==1){
							verArticulos(nombre,usuarios,salidaalCliente);
						}else if(numero==2){
							addArticulo(nombre,usuarios, mensajedelCliente,salidaalCliente);
						}else if(numero==3){
							delArticulo(nombre,usuarios, mensajedelCliente,salidaalCliente);
						}
						
					}else if(numero==0){
						salidaalCliente.println("Adios");//(7)Enviamos Adios
					}
					
				}while(numero!=0);
			}else salidaalCliente.println("El Usuario No Existe");//(7)Enviamos No existe
			
		}catch(Exception e){
			e.getMessage();
		}
	}
	private void delArticulo(String nombre, ArrayList<Usuario> usuarios2,
			BufferedReader mensajedelCliente, PrintWriter salidaalCliente) {
		try{
			salidaalCliente.println("Introduzca Numero de Articulo");//(5)Enviamos Numero
			int articulo = Integer.parseInt(mensajedelCliente.readLine());//(4)Esperamos Numero
			Usuario usuario = buscarUsuario(nombre, usuarios2);
			if(usuario!=null){
				String respuesta = usuario.delArticulo(articulo);
				salidaalCliente.println(respuesta);//(6)Enviamos Respuesta
			}
			
			
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	private void addArticulo(String nombre, ArrayList<Usuario> usuarios2,
			BufferedReader mensajedelCliente, PrintWriter salidaalCliente) {
		try{
			salidaalCliente.println("Introduzca Articulo");//(2)Enviamos Articulo
			String articulo = mensajedelCliente.readLine();//(3)Esperamos Articulo
			Usuario usuario = buscarUsuario(nombre, usuarios2);
			if(usuario!=null){
				String respuesta = usuario.addArticulo(new Articulo(articulo));
				salidaalCliente.println(respuesta);//(3)Enviamos Respuesta
			}
			
			
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	private void verArticulos(String nombre, ArrayList<Usuario> usuarios2,
			PrintWriter salidaalCliente) {
		Usuario usuario = buscarUsuario(nombre, usuarios2);
		if(usuario!=null){
			String articulos = usuario.verArticulos();
			salidaalCliente.println(articulos);//(4)Enviamos Lista Articulos
		}
		
	}
	private Usuario buscarUsuario(String nombre, ArrayList<Usuario> usuarios2) {
		for (int i = 0; i < usuarios2.size(); i++) {
			Usuario usuario = usuarios2.get(i);
			if (usuario.getNombre().equalsIgnoreCase(nombre))
			{
				return usuario;
			}
		}
		return null;
	}
	private void rellenarArray(ArrayList<Usuario> usuarios2) {
		usuarios2.add(new Usuario("Ana"));
		usuarios2.add(new Usuario("Carmen"));
		usuarios2.add(new Usuario("Juan"));
		usuarios2.add(new Usuario("Carlos"));
		usuarios2.add(new Usuario("Felipe"));
		usuarios2.add(new Usuario("Katy"));		
	}
}
