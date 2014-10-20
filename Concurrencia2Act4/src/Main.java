public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Almacen a = new Almacen();
		Mounstruo m1 = new Mounstruo(a, "Mounstruo 1");
		Mounstruo m2 = new Mounstruo(a, "Mounstruo 2");
		Mounstruo m3 = new Mounstruo(a, "Mounstruo 3");
		Almacenero al = new Almacenero(a);
		m1.start();
		m2.start();
		m3.start();
		al.start();

	}

}
