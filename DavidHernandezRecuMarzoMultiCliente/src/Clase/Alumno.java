package Clase;

import java.util.ArrayList;

public class Alumno {

	String nombre = "";
	ArrayList<Nota> notas = null;

	public String getNombre() {
		return nombre;
	}

	public Alumno(String nombre) {
		this.nombre = nombre;
		this.notas = new ArrayList();
	}

	public String mostrar(int i) {
		return notas.get(i).toString();
	}
	
	public String listar() {
        String s = "Lista de Notas \n";
        for (int i = 0; i < notas.size(); i++) {
            s += i + " - " + notas.get(i).getNota() + "\n";
        }
        return s;
    }

	public String anadir(Nota n) {
		notas.add(n);
		return "Operacion realizada con exito";
	}
}
