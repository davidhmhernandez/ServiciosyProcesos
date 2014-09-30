
public class Dado1 extends Thread {
	int valorDado1;

	public Dado1() {
	}

	@Override
	public void run() {
		valorDado1 = (int) Math.floor(Math.random() * 6 + 1);

	}

}
