package Clase;

import java.util.ArrayList;

public class Alumno {
	private String nombre;
	private ArrayList<Nota> notas;
	
	public Alumno(String nombre) {
		this.nombre=nombre;
		this.notas=new ArrayList<Nota>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String verNotas(){
		String s = "Lista de Notas ";
		for(int i=0;i<notas.size();i++){
			s+=notas.get(i).getCalificacion();
		}
		return s;
	}
	
	public String addNota(Nota n){
		notas.add(n);
		return "Nota A–adida";
	}
	
	public String verMedia(){
		String s = "Media = ";
		int sumaNotas = 0;
		int media = 0;
		int i=0;
		for(;i<notas.size();i++){
			sumaNotas+=notas.get(i).getCalificacion();
		}
		media = sumaNotas/i;
		String mediaS=Integer.toString(media);
		return mediaS;
	}

}
