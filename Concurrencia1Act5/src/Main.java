public class Main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i <= 2; i++) {
			Jugador t1 = new Jugador();
			Jugador t2 = new Jugador();
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			System.out.println(t1.valorJ1);
			System.out.println(t2.valorJ1);

			if (t1.valorJ1.equals(t2.valorJ1)) {
				System.out.println("Empate\n");
			} else if (t1.valorJ1.equals("Piedra")
					&& t2.valorJ1.equals("Tijeras")) {
				System.out.println("Gana el Jugador 1\n");
			} else if (t1.valorJ1.equals("Piedra")
					&& t2.valorJ1.equals("Papel")) {
				System.out.println("Gana el Jugador 2\n");
			} else if (t1.valorJ1.equals("Papel")
					&& t2.valorJ1.equals("Tijeras")) {
				System.out.println("Gana el Jugador 2\n");
			} else if (t1.valorJ1.equals("Papel")
					&& t2.valorJ1.equals("Piedra")) {
				System.out.println("Gana el Jugador 1\n");
			} else if (t1.valorJ1.equals("Tijeras")
					&& t2.valorJ1.equals("Piedra")) {
				System.out.println("Gana el Jugador 2\n");
			} else if (t1.valorJ1.equals("Tijeras")
					&& t2.valorJ1.equals("Papel")) {
				System.out.println("Gana el Jugador 1\n");
			}
		}
	}

}
