package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor extends Thread{
	private ServerSocket ss;
	private Socket s;
	private ArrayList<Tarjeta> tarjetas;

	public Servidor(ServerSocket ss, Socket s, ArrayList<Tarjeta> tarjetas) {
		this.s = s;
		this.ss = ss;
		this.tarjetas = tarjetas;
	}

	@Override
	public void run() {
		PrintWriter salidaAlCliente = null;
		try {
			// inicializamos la salida y entrada del cliente
			BufferedReader entradaDesdeElCliente = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			 salidaAlCliente = new PrintWriter(s.getOutputStream(),
					true);
			String idAux = "";
			String claveAux = "";
			String codigoAux = "";
			String dineroAux = "";

			int id = 0;
			int clave = 0;
			int codigo = 0;
			double dinero = 0;
			do {
				salidaAlCliente.println("Numero de tarjeta: ");
				idAux = entradaDesdeElCliente.readLine();
			} while (idAux.length() != 8);
			// SELECCIONAR TARJETA
			id = Integer.parseInt(idAux);
			Tarjeta tarjeta = buscarTarjeta(tarjetas, id);
			if (tarjeta != null) {
				synchronized (tarjeta) {
					System.out.println(tarjeta);
					System.out.println("********************");
					// COMPROBAR CLAVE
					do {
						salidaAlCliente.println("Clave Tarjeta: ");
						claveAux = entradaDesdeElCliente.readLine();
					} while (claveAux.length() != 4);
					clave = Integer.parseInt(claveAux);
					if (comprobarClave(tarjeta, clave)) {
						

						do {
							salidaAlCliente
									.println("1.- Sacar  || 2.- Ingresar   ");
							codigoAux = entradaDesdeElCliente.readLine();
							codigo = Integer.parseInt(codigoAux);
						} while (codigo != 1 && codigo != 2);

						do {
							salidaAlCliente.println("Cantidad De Dinero: ");
							dineroAux = entradaDesdeElCliente.readLine();
							dinero = Double.parseDouble(dineroAux);
						} while (dinero < 0);

						// REALIZAR OPERACION
						if (operacionARealizar(tarjeta, codigo, dinero)) {
							salidaAlCliente
									.println("Operacion realizada correctamente");

							System.out.println(tarjeta);
							s.close();
							entradaDesdeElCliente.close();
							salidaAlCliente.close();
						} else {
							salidaAlCliente.println("Operacion NO realizada");
						}
					} else {
						salidaAlCliente.println("Clave Incorrecta");
					}
				}
			} else {
				salidaAlCliente.println("Tarjeta Incorrecta");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			salidaAlCliente.println("Error Irrecuperable");
		}
	}

	/**
	 * Metodo para buscar el numero de una tarjeta y comprobrar si la misma
	 * existe.
	 * 
	 * @param tarjetas
	 *            Array donde estan todas las tarjetas almacenadas
	 * @param id
	 *            id de la tarjeta a buscar
	 * @return devuelve null en caso de no encontrar la tarjeta , en caso de
	 *         encontrarla devuelve el objeto tarjeta
	 */
	private Tarjeta buscarTarjeta(ArrayList<Tarjeta> tarjetas, int id) {
		for (int i = 0; i < tarjetas.size(); i++) {
			Tarjeta aux = tarjetas.get(i);
			if (aux.getNumero() == id) {
				return aux;
			}
		}
		return null;
	}

	/**
	 * Metodo para comprobar la clave de una tarjeta
	 * 
	 * @param targeta
	 *            tarjeta la cual se comprobara la clave
	 * @param clave
	 *            clave a verificar
	 * @return devuelve verdadero si la clave es correcta y falso en cualquier
	 *         caso contrario
	 */
	private boolean comprobarClave(Tarjeta targeta, int clave) {
		if (targeta.getClave() == clave)
			return true;
		else
			return false;
	}

	/**
	 * Metodo para realizar las operaciones de deposito / extraccion de dinero
	 * dentro de una tarjeta
	 * 
	 * @param tarjeta
	 *            tarjeta con al cuals e va a operar
	 * @param operacion
	 *            tipo de operacion a realizar 1 = sacar Dinero, 2 = depositar
	 *            dinero
	 * @param dinero
	 *            Cantidad de dinero a depositar
	 * @return devuelve true si la operacion fue concretada correctamente y
	 *         falso en cualquier caso de error
	 */
	private boolean operacionARealizar(Tarjeta tarjeta, int operacion,
			double dinero) {
		switch (operacion) {
		case 1:/* Sacar Dinero */
			if ((tarjeta.getSaldo() - dinero) > 0) {
				tarjeta.setSaldo((tarjeta.getSaldo() - dinero));
				return true;
			} else
				return true;
		case 2:/* Ingresar Dinero */
			tarjeta.setSaldo((tarjeta.getSaldo() + dinero));
			return true;
		default:
			return false;
		}
	}

}

