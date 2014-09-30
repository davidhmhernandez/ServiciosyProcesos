
public class Dado2 extends Thread {
	int valorDado2;

	public Dado2() {
		valorDado2 = (int) Math.floor(Math.random() * 6 + 1);

	}

}
