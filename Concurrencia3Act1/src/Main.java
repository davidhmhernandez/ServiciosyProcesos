
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Almacen a = new Almacen();
		Mounstruo m1 = new Mounstruo(a, "Monstruo 1");
		Mounstruo m2 = new Mounstruo(a, "Monstruo 2");
//		Mounstruo m3 = new Mounstruo(a, "Monstruo 3");
//		Mounstruo m4 = new Mounstruo(a, "Monstruo 4");
//		Mounstruo m5 = new Mounstruo(a, "Monstruo 5");
//		Mounstruo m6 = new Mounstruo(a, "Monstruo 6");
		Almecenero al = new Almecenero(a);
		
		m1.start();
		m2.start();
//		m3.start();
//		m4.start();
//		m5.start();
//		m6.start();
		al.start();

	}

}
