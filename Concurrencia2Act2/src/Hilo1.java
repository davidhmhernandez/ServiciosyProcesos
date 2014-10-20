import java.util.Scanner;

public class Hilo1 extends Thread {
	static Monitor monitor = null;

	public Hilo1(Monitor o) {
		this.monitor = o;
	}

	@Override
	public void run() {
		synchronized (monitor) {
			boolean sigue = true;
			while (sigue) {
				System.out.print("Escribe algo con " + getName() + ": ");
				Scanner sc = new Scanner(System.in);
				String probar= sc.next();
				if (probar.equalsIgnoreCase("fin")) {
					System.out.println("adios h1");
					monitor.notify();
					monitor.setMuerto(true);
					sigue = false;
				} else if (monitor.getMuerto() == false) {
					monitor.notify();
					try {
						monitor.wait();
					} catch (InterruptedException ex) {
					}
				}
			}
			monitor.notify();
		}

	}
}
