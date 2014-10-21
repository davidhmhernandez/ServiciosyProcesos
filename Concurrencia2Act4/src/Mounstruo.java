import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mounstruo extends Thread {
	Almacen almacen = null;
	private Scanner s;

	public Mounstruo(Almacen a, String s) {
		super(s);
		this.almacen = a;
	}

	public void run() {
		for (;;) {
			synchronized (almacen) {
				if (almacen.getGalletas() != 0) {
					s = new Scanner(System.in);
					System.out.println("numero de galletas "
							+ Thread.currentThread().getName());
					int galletasQueMeComo = s.nextInt();
					almacen.comer(galletasQueMeComo);
					try {
						System.out.println(Thread.currentThread().getName()
								+ " Me hecho una siesta dentro del almacen de "
								+ galletasQueMeComo * 500 + "ms");
						sleep(galletasQueMeComo * 500);
						System.out.println(Thread.currentThread().getName()
								+ " Salgo del almacen 1/2 segundo ");
						almacen.wait(500);
					} catch (InterruptedException ex) {
						Logger.getLogger(Mounstruo.class.getName()).log(
								Level.SEVERE, null, ex);
					}
				}if(almacen.isTerminado())break;
			}
		}
		//**	Aqui **/
		
		System.out.println(Thread.currentThread().getName() + " termino ok");
	}

}
