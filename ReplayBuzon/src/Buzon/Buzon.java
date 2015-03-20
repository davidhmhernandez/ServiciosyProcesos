package Buzon;

import java.util.ArrayList;

public class Buzon {
	private String nombreUsuario;
	ArrayList<Mensaje> mensajes;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Buzon(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
		this.mensajes = new ArrayList<Mensaje>();
	}

	public String listar() {
		String s = "Lista de Mis Mensajes ";
		for(int i=0;i<mensajes.size();i++){
			s+=mensajes.get(i).getAsunto();
		}
		return s;
	}

	public String mostrar(int i) {
		String s = "Mensaje Numero "+i;
		for(int j=0;j<mensajes.size();j++){
			s+= mensajes.get(j).toString();
		}
		return s;
	}

	public String borrar(int i) {
		String s = "Borrado del Mensaje "+i;
		for(int j=0;j<mensajes.size();j++){
			mensajes.remove(j);
			s+=" OK";
		}
		return s;
	}

	public String add(Mensaje m) {
		mensajes.add(m);
		String s = "Mensaje A–adido";
		return s;
	}

}
