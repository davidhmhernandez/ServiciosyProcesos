import java.util.Scanner;


public class Almecenero extends Thread {
	Almacen a = null;
	private String repon;
	private Scanner s;

	public Almecenero(Almacen a) {
		this.a = a;
	}

	public void run() {
		repon = "s";
		for (;;) {

			
			
				if (a.getGalletas() == 0) {
				a.adquirir();
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
		                        a.soltar();
		                        

//							try {
////								a.wait(500);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
		                        break;
		                    case 2:
		                    	System.out.println("No Repongo Galletas");
		                    	a.setTerminado(true);
		                        break;
		                        

						 }if(a.isTerminado())break;
					}
				
			}
		
		
		}
		a.soltar();
		System.out.println("almacenero termino ok");
		
		
	}

}