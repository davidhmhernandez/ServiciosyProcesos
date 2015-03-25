package Supermercado;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private ArrayList<Articulo>articulos;
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		this.articulos = new ArrayList<Articulo>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String verArticulos(){
		String s = "Lista de Articulos ";
		for(int i=0;i<articulos.size();i++){
			s+=articulos.get(i).getNombre();
		}
		return s;
	}
	
	public String addArticulo(Articulo a){
		articulos.add(a);
		return "Articulo Añadido";
	}
	
	public String delArticulo(int i){
		String s = "Borrado del Articulo " + i;
		for (int j = 0; j < articulos.size(); j++) {
			articulos.remove(j);
			s += " OK";
		}
		return s;
	}

}
