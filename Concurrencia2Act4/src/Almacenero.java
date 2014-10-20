import java.util.logging.Level;
import java.util.logging.Logger;

public class Almacenero extends Thread {
	Almacen a = null;
	private String repon;

	public Almacenero(Almacen a) {
		this.a = a;
	}

	public void run() {
		repon = "s";
		for (;;) {
			synchronized (a) {
				if (a.getGalletas() == 0) {
					System.out.println("Almacenero compruebo el numero de galletas");
					if (a.getGalletas() == 0) {
						try {
							a.reponer();
							System.out.println("Almacenero Salgo del almacen 1/2 segundo ");
							a.wait(500);
						} catch (InterruptedException ex) {
							Logger.getLogger(Almacenero.class.getName()).log(
									Level.SEVERE, null, ex);
						}
					}
				}
			}
		}

	}

}
