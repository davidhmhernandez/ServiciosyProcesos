package Servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Banco.Tarjeta;

public class Servidor extends Thread {
	private ServerSocket ss;
	private Socket s;
	private ArrayList<Tarjeta> tarjetas;

	public Servidor(ServerSocket ss, Socket s, ArrayList<Tarjeta> tarjetas) {
		this.ss = ss;
		this.s = s;
		this.tarjetas = tarjetas;
	}

	@Override
	public void run() {
		rellenarArrayList(tarjetas);
		try {
			BufferedReader mensajedelCliente = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			PrintWriter salidaalCliente = new PrintWriter(s.getOutputStream(),
					true);

			int numero;

			do {
				numero = Integer.parseInt(mensajedelCliente.readLine());
				if(numero ==1 || numero ==2){
					int cuenta = Integer.parseInt(mensajedelCliente.readLine());
					Tarjeta tarjeta = buscarTarjeta(tarjetas,cuenta);
					if(tarjeta !=null){
						if(numero==1){
							sacarDinero(cuenta,tarjetas,mensajedelCliente,salidaalCliente);
						}else if(numero==2){
							ingresardinero(cuenta,tarjetas,mensajedelCliente,salidaalCliente);
						}
					}else salidaalCliente.println("La Cuenta No Existe");
				}else if(numero ==0){
					salidaalCliente.println("Adios");
				}else salidaalCliente.println("Numero Incorrecto");

			} while (numero != 0);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void rellenarArrayList(ArrayList<Tarjeta> tarjetas2) {
		tarjetas2.add(new Tarjeta(11111111,2222,3000));
		tarjetas2.add(new Tarjeta(22222222,3333,4000));
		tarjetas2.add(new Tarjeta(33333333,4444,5000));
		tarjetas2.add(new Tarjeta(44444444,5555,6000));
	}

	private void ingresardinero(int cuenta, ArrayList<Tarjeta> tarjetas2,
			BufferedReader mensajedelCliente, PrintWriter salidaalCliente) {
		try{
			salidaalCliente.println("Dinero a Ingresar");
			double dinero = Double.parseDouble(mensajedelCliente.readLine());
			Tarjeta tarjeta = buscarTarjeta(tarjetas2, cuenta);
			tarjeta.setSaldo(tarjeta.getSaldo()+dinero);
		}catch(Exception e){
			e.getMessage();
		}
		
	}

	private void sacarDinero(int cuenta, ArrayList<Tarjeta> tarjetas2,
			BufferedReader mensajedelCliente, PrintWriter salidaalCliente) {
		try{
			salidaalCliente.println("Introduzca PIN");
			int pin = Integer.parseInt(mensajedelCliente.readLine());
			
			salidaalCliente.println("Dinero a Sacar");
			double dinero = Double.parseDouble(mensajedelCliente.readLine());
			
			Tarjeta tarjeta = comprobarDatos(tarjetas,cuenta,pin,dinero);
			tarjeta.setSaldo(tarjeta.getSaldo()-dinero);
		}catch(Exception e){
			e.getMessage();
		}
	}

	private Tarjeta comprobarDatos(ArrayList<Tarjeta> tarjetas2, int cuenta,
			int pin, double dinero) {
		for (int i = 0; i < tarjetas2.size(); i++) {
			Tarjeta aux = tarjetas2.get(i);
			if (aux.getNumero() == cuenta && aux.getClave() == pin
					&& aux.getSaldo() >= dinero) {
				return aux;
			}
		}
		return null;
	}

	private Tarjeta buscarTarjeta(ArrayList<Tarjeta> tarjetas2, int numero) {
		for (int i = 0; i < tarjetas2.size(); i++) {
			Tarjeta aux = tarjetas2.get(i);
			if (aux.getNumero() == numero) {
				return aux;
			}
		}
		return null;
	}
}
