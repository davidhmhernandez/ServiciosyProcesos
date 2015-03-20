package Buzon;

public class Mensaje {
	private String asunto;
	private String cuerpo;
	private String origen;

	public Mensaje(String asunto, String cuerpo, String origen) {
		this.asunto = asunto;
		this.cuerpo = cuerpo;
		this.origen = origen;
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

	public String toString() {
		String s = "De: " + origen;
		s += " Asunto: " + asunto;
		s += " Mensaje: " + cuerpo;
		return s;
	}

}
