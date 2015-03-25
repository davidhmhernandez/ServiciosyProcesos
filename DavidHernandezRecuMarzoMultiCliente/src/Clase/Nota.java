package Clase;

public class Nota {
	private String nombre;
	private int nota;

	public Nota(String nombre,int nota) {
		this.nombre=nombre;
		this.nota = nota;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		String s = "Nota: " + nota;
		return s;
	}
}
