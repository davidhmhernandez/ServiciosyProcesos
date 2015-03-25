package Servidor;

public class Mensaje {
	private int ID;

	private String asunto;
	private String cuerpo;
	private String origen;

	public Mensaje(int id, String origen, String asunto, String cuerpo) {
		this.ID = id;
		this.origen = origen;
		this.asunto = asunto;
		this.cuerpo = cuerpo;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String toString() {
		String s = "De: " + origen;
		s += " Asunto: " + asunto;
		s += " Mensaje: " + cuerpo;
		return s;
	}
}
