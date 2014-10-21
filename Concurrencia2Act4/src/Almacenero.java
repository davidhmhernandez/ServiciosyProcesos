import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Almacenero extends Thread {
	Almacen a = null;
	private String repon;
	private Scanner s;

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
						System.out.println("¿Desea Reponer Galletas? 1-Si 2-No");
						s = new Scanner(System.in);
						int opc = s.nextInt();
						 switch (opc) {
		                    case 1:
		                        System.out.println("Galletas Repuestas");
		                        a.reponer();
		                        System.out.println("Almacenero Salgo del almacen 1/2 segundo ");
							try {
								a.wait(500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                        break;
		                    case 2:
		                    	System.out.println("No Repongo Galletas");
		                    	a.setTerminado(true);
		                        break;
		                        

						 }if(a.isTerminado())break;
					}
				}
			}
		
		
		}
		//**	Aqui **/
		System.out.println("almacenero termino ok");
		
		
	}

}
