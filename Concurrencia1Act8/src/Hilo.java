public class Hilo extends Thread {
	int i = 0;

	public Hilo(int i) {
		this.i = i;
	}
	
	public void run() {
	       System.out.println("Soy Hilo "+i);
	       try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }

}
