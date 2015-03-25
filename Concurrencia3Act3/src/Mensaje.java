
public class Mensaje extends Thread {
	
	Buzon b = null;
	
	private static char mensaje = ' ';
	
	
	@Override
	public void run() {
		for(;;){
			int resultado =(int)(Math.random()*26+65);
			mensaje = (char)resultado;
			System.out.println(mensaje);
		}
	}

}
